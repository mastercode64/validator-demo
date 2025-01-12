package com.mastercode.validatordemo.validators

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ValidatorConfigTest {
    @Autowired
    private lateinit var validators: List<Validator>

    @Test
    fun `should inject all validators`() {
        assertEquals(3, validators.size)
        assertTrue(validators.any { it is GenericValidator })
        assertTrue(validators.any { it is OrderValidator })
        assertTrue(validators.any { it is TransactionValidator })
    }
}