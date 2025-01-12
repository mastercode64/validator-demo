package com.mastercode.validatordemo.rules

import com.mastercode.validatordemo.model.Occurrence
import com.mastercode.validatordemo.model.ValidationError
import org.springframework.stereotype.Component

@Component
class RuleInvalidValue : ValidationRule {
    override fun validate(occurrence: Occurrence): ValidationError? {
        if (occurrence.value.toInt() == 0)
            return ValidationError.INVALID_VALUE
        return null
    }
}