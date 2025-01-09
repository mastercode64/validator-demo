package com.mastercode.validator.rules

import com.mastercode.validator.model.Occurrence
import com.mastercode.validator.model.ValidationError
import org.springframework.stereotype.Component

@Component
class RuleInvalidValue : ValidationRule {
    override fun validate(occurrence: Occurrence): ValidationError? {
        if (occurrence.value <= 0)
            return ValidationError.INVALID_VALUE
        return null
    }
}