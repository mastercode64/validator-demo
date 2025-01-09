package com.mastercode.validator.rules

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OccurrenceValidationConfig {
    @Bean
    fun validationRules(
        invalidId: RuleInvalidId,
        invalidValue: RuleInvalidValue
    ) = listOf(
        invalidId,
        invalidValue
    )

}