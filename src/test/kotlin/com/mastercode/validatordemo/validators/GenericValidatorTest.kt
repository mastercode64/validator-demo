package com.mastercode.validatordemo.validators

import com.mastercode.validatordemo.model.OccurrenceType
import com.mastercode.validatordemo.rules.RuleEmptyDescription
import com.mastercode.validatordemo.rules.RuleInvalidId
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class GenericValidatorTest{
    @Autowired
    private lateinit var validator: GenericValidator

    @Test
    fun `generic validator should inject correct rules`() {
        assertEquals(2, validator.rules.size)
        assertTrue(validator.rules.any { it is RuleInvalidId })
        assertTrue(validator.rules.any { it is RuleEmptyDescription })
    }

    @Test
    fun `validator should validate all occurrence types`() {
        assertTrue(validator.shouldValidate(OccurrenceType.ORDER))
        assertTrue(validator.shouldValidate(OccurrenceType.TRANSACTION))
        assertTrue(validator.shouldValidate(OccurrenceType.PERIOD))
    }

}