package com.mastercode.validatordemo.validators

import com.mastercode.validatordemo.rules.RuleEmptyDescription
import com.mastercode.validatordemo.rules.RuleInvalidDescription
import com.mastercode.validatordemo.rules.RuleInvalidId
import com.mastercode.validatordemo.rules.RuleInvalidValue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ValidatorConfig {
    @Bean(name = ["GENERIC"])
    fun genericRules(
        invalidId: RuleInvalidId,
        emptyDescription: RuleEmptyDescription
    ) = listOf(
        invalidId,
        emptyDescription
    )

    @Bean(name = ["ORDER"])
    fun orderRules(
        invalidDescription: RuleInvalidDescription
    ) = listOf(
        invalidDescription,
    )

    @Bean(name = ["TRANSACTION"])
    fun transactionRules(
        invalidValue: RuleInvalidValue
    ) = listOf(
        invalidValue,
    )
}