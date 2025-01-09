package com.mastercode.validator

import com.mastercode.validator.rules.RuleInvalidId
import com.mastercode.validator.rules.RuleInvalidValue
import com.mastercode.validator.rules.ValidationRule
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ValidatorTest {
    @Autowired
    private lateinit var validationRules: List<ValidationRule>

    @Test
    fun `should inject all validation rules`() {
        assertEquals(2, validationRules.size)

        val ruleInvalidId = validationRules.any { it is RuleInvalidId }
        val ruleInvalidValue = validationRules.any { it is RuleInvalidValue }

        assertTrue(ruleInvalidId)
        assertTrue(ruleInvalidValue)
    }
}