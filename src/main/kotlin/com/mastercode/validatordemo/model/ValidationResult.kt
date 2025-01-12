package com.mastercode.validatordemo.model

data class ValidationResult(
    val validatorType: String,
    val occurrence: Occurrence,
    val errors: List<ValidationError>
)
