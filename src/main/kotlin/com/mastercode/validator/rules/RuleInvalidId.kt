package com.mastercode.validator.rules

import com.mastercode.validator.model.Occurrence
import com.mastercode.validator.model.ValidationError
import org.springframework.stereotype.Component

@Component
class RuleInvalidId : ValidationRule {
    override fun validate(occurrence: Occurrence): ValidationError? {
        if (occurrence.entityId == "")
            return ValidationError.INVALID_ID
        return null
    }
}