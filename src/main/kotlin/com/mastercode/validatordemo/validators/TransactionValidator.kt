package com.mastercode.validatordemo.validators

import com.mastercode.validatordemo.model.Occurrence
import com.mastercode.validatordemo.model.OccurrenceType
import com.mastercode.validatordemo.model.ValidationResult
import com.mastercode.validatordemo.rules.RuleInvalidId
import com.mastercode.validatordemo.rules.RuleInvalidValue
import com.mastercode.validatordemo.rules.ValidationRule
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
class TransactionValidator(
    @Qualifier("TRANSACTION")
    val rules: List<ValidationRule>
) : Validator {

    private val type = OccurrenceType.TRANSACTION
    override fun type(): String {
        return this.type.toString()
    }

    override fun shouldValidate(occurrenceType: OccurrenceType): Boolean {
        return occurrenceType == this.type
    }

    override fun validate(occurrence: Occurrence): ValidationResult? {
        println("Transaction validator processing")
        val errors = rules.mapNotNull { it.validate(occurrence) }
        if (errors.isEmpty()) return null
        return ValidationResult(
            validatorType = this.type(),
            occurrence = occurrence,
            errors = errors
        )
    }
}