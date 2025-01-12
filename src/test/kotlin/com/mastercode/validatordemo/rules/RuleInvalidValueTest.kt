package com.mastercode.validatordemo.rules

import com.mastercode.validatordemo.fixture.OccurrenceFixture.orderOccurrence
import com.mastercode.validatordemo.model.ValidationError
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RuleInvalidValueTest {
    @Autowired
    private lateinit var rule: RuleInvalidValue

    @Test
    fun `occurrence with invalid value should return error`() {
        val occurrence = orderOccurrence.copy(value = 0)
        val error = rule.validate(occurrence)
        assertEquals(ValidationError.INVALID_VALUE, error)
    }

    @Test
    fun `occurrence with valid value should not return error`() {
        val occurrence = orderOccurrence.copy(value = 10)
        val error = rule.validate(occurrence)
        assertNull(error)
    }
}