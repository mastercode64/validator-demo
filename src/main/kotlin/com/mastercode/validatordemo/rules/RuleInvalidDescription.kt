package com.mastercode.validatordemo.rules

import com.mastercode.validatordemo.model.Occurrence
import com.mastercode.validatordemo.model.ValidationError
import org.springframework.stereotype.Component

@Component
class RuleInvalidDescription : ValidationRule {
    override fun validate(occurrence: Occurrence): ValidationError? {
        if (occurrence.description.contains("order", true).not())
            return ValidationError.INVALID_DESCRIPTION
        return null
    }
}