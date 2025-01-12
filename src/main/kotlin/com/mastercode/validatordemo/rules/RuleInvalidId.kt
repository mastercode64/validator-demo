package com.mastercode.validatordemo.rules

import com.mastercode.validatordemo.model.Occurrence
import com.mastercode.validatordemo.model.ValidationError
import org.springframework.stereotype.Component

@Component
class RuleInvalidId : ValidationRule {
    override fun validate(occurrence: Occurrence): ValidationError? {
        if (occurrence.entityId == "")
            return ValidationError.INVALID_ID
        return null
    }
}