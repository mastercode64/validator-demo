package com.mastercode.validator

import com.mastercode.validator.model.Occurrence
import com.mastercode.validator.rules.ValidationRule
import org.springframework.stereotype.Component

@Component
class Validator(
    private val rules: List<ValidationRule>
) {
    fun validate(occurrence: Occurrence): List<String> {
        return rules
            .mapNotNull {
                it.validate(occurrence)
            }.map { it.toString() }
    }
}