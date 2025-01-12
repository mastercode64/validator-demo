package com.mastercode.validatordemo.validators

import com.mastercode.validatordemo.model.OccurrenceType
import com.mastercode.validatordemo.rules.RuleEmptyDescription
import com.mastercode.validatordemo.rules.RuleInvalidDescription
import com.mastercode.validatordemo.rules.RuleInvalidId
import com.mastercode.validatordemo.rules.RuleInvalidValue
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TransactionValidatorTest{
    @Autowired
    private lateinit var validator: TransactionValidator

    @Test
    fun `transaction validator should inject correct rules`() {
        assertEquals(1, validator.rules.size)
        assertTrue(validator.rules.any { it is RuleInvalidValue })
    }

    @Test
    fun `validator should validate only occurrence type TRANSACTION`() {
        assertTrue(validator.shouldValidate(OccurrenceType.TRANSACTION))
        assertFalse(validator.shouldValidate(OccurrenceType.ORDER))
        assertFalse(validator.shouldValidate(OccurrenceType.PERIOD))
    }

}