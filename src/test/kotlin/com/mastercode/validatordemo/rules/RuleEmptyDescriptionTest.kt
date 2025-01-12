package com.mastercode.validatordemo.rules

import com.mastercode.validatordemo.fixture.OccurrenceFixture.orderOccurrence
import com.mastercode.validatordemo.model.ValidationError
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RuleEmptyDescriptionTest {
    @Autowired
    private lateinit var rule: RuleEmptyDescription

    @Test
    fun `occurrence with empty description should return error`() {
        val occurrence = orderOccurrence.copy(description = "")
        val error = rule.validate(occurrence)
        assertEquals(ValidationError.EMPTY_DESCRIPTION, error)
    }

    @Test
    fun `occurrence with description should not return error`() {
        val occurrence = orderOccurrence.copy(description = "123")
        val error = rule.validate(occurrence)
        assertNull(error)
    }
}