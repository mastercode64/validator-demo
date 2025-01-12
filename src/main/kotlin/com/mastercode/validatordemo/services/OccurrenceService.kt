package com.mastercode.validatordemo.services

import com.mastercode.validatordemo.model.Occurrence
import com.mastercode.validatordemo.model.ValidationResult
import com.mastercode.validatordemo.validators.Validator
import org.springframework.stereotype.Service

@Service
class OccurrenceService(
    private val validators: List<Validator>
) {
    fun process(occurrence: Occurrence): List<ValidationResult> {
        val errors = validators
            .filter { it.shouldValidate(occurrence.type)}
            .mapNotNull { it.validate(occurrence) }
        return errors
    }
}