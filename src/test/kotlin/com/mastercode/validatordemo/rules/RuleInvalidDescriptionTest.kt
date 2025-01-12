package com.mastercode.validatordemo.rules

import com.mastercode.validatordemo.fixture.OccurrenceFixture.orderOccurrence
import com.mastercode.validatordemo.model.ValidationError
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RuleInvalidDescriptionTest {
    @Autowired
    private lateinit var rule: RuleInvalidDescription

    @Test
    fun `occurrence with invalid description should return error`() {
        val occurrence = orderOccurrence.copy(description = "invalid description")
        val error = rule.validate(occurrence)
        assertEquals(ValidationError.INVALID_DESCRIPTION, error)
    }

    @Test
    fun `occurrence with valid description should not return error`() {
        val occurrence = orderOccurrence.copy(description = "order 123")
        val error = rule.validate(occurrence)
        assertNull(error)
    }
}