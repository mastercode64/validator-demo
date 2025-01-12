package com.mastercode.validatordemo.services

import com.mastercode.validatordemo.fixture.OccurrenceFixture.orderOccurrence
import com.mastercode.validatordemo.fixture.OccurrenceFixture.periodOccurrence
import com.mastercode.validatordemo.fixture.OccurrenceFixture.transactionOccurrence
import com.mastercode.validatordemo.model.ValidationError
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class OccurrenceServiceTest {
    @Autowired
    private lateinit var service: OccurrenceService

    @Test
    fun `valid occurrence should not return validation errors`() {
        val occurrence = orderOccurrence
        val validationResults = service.process(occurrence)
        assertEquals(0, validationResults.size)
    }

    @Test
    fun `invalid occurrence should return GENERIC validation errors`() {
        val occurrence = periodOccurrence.copy(
            entityId = "",
            description = ""
        )
        val result = service.process(occurrence)
        assertEquals(1, result.size)

        with(result[0]) {
            assertEquals("GENERIC", this.validatorType)
            assertEquals(occurrence, this.occurrence)
            assertEquals(listOf(ValidationError.INVALID_ID, ValidationError.EMPTY_DESCRIPTION), this.errors)
        }
    }

    @Test
    fun `invalid ORDER occurrence should return validation errors`() {
        val occurrence = orderOccurrence.copy(
            entityId = "",
            description = "123"
        )
        val result = service.process(occurrence)

        assertEquals(2, result.size)

        with(result[0]) {
            assertEquals("GENERIC", this.validatorType)
            assertEquals(occurrence, this.occurrence)
            assertEquals(listOf(ValidationError.INVALID_ID), this.errors)
        }
        with(result[1]) {
            assertEquals("ORDER", this.validatorType)
            assertEquals(occurrence, this.occurrence)
            assertEquals(listOf(ValidationError.INVALID_DESCRIPTION), this.errors)
        }
    }

    @Test
    fun `invalid TRANSACTION occurrence should return validation errors`() {
        val occurrence = transactionOccurrence.copy(
            value = 0
        )
        val result = service.process(occurrence)
        assertEquals(1, result.size)

        with(result[0]) {
            assertEquals("TRANSACTION", this.validatorType)
            assertEquals(occurrence, this.occurrence)
            assertEquals(listOf(ValidationError.INVALID_VALUE), this.errors)
        }
    }
}