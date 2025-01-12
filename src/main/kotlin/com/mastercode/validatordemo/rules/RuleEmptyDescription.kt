package com.mastercode.validatordemo.rules

import com.mastercode.validatordemo.model.Occurrence
import com.mastercode.validatordemo.model.ValidationError
import org.springframework.stereotype.Component

@Component
class RuleEmptyDescription : ValidationRule {
    override fun validate(occurrence: Occurrence): ValidationError? {
        if (occurrence.description.isBlank())
            return ValidationError.EMPTY_DESCRIPTION
        return null
    }
}