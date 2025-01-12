package com.mastercode.validatordemo.validators

import com.mastercode.validatordemo.model.Occurrence
import com.mastercode.validatordemo.model.OccurrenceType
import com.mastercode.validatordemo.model.ValidationResult

interface Validator {
    fun type(): String
    fun shouldValidate(occurrenceType: OccurrenceType): Boolean
    fun validate(occurrence: Occurrence): ValidationResult?
}