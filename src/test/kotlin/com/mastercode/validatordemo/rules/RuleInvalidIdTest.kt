package com.mastercode.validatordemo.rules

import com.mastercode.validatordemo.fixture.OccurrenceFixture.orderOccurrence
import com.mastercode.validatordemo.model.ValidationError
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RuleInvalidIdTest {
    @Autowired
    private lateinit var rule: RuleInvalidId

    @Test
    fun `occurrence with invalid id should return error`() {
        val occurrence = orderOccurrence.copy(entityId = "")
        val error = rule.validate(occurrence)
        assertEquals(ValidationError.INVALID_ID, error)
    }

    @Test
    fun `occurrence with valid id should not return error`() {
        val occurrence = orderOccurrence.copy(entityId = "123")
        val error = rule.validate(occurrence)
        assertNull(error)
    }
}