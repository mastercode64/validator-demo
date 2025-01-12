package com.mastercode.validatordemo.rules

import com.mastercode.validatordemo.model.Occurrence
import com.mastercode.validatordemo.model.ValidationError

interface ValidationRule {
    fun validate(occurrence: Occurrence): ValidationError?
}