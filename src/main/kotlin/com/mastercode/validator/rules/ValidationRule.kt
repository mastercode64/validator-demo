package com.mastercode.validator.rules

import com.mastercode.validator.Validator
import com.mastercode.validator.model.Occurrence
import com.mastercode.validator.model.ValidationError

interface ValidationRule {
    fun validate(occurrence: Occurrence): ValidationError?
}