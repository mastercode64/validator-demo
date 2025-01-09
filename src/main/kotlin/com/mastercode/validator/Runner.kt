package com.mastercode.validator

import com.mastercode.validator.model.Occurrence
import com.mastercode.validator.model.OccurrenceType
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class Runner(
    private val validator: Validator
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        println("starting validation")
        val occurrences = listOf(
            Occurrence(
                value = 0,
                entityId = "",
                type = OccurrenceType.ORDER
            ),
            Occurrence(
                value = 0,
                entityId = "1",
                type = OccurrenceType.PERIOD
            )
        )

        occurrences.forEach { occurrence ->
            val errors = validator.validate(occurrence)
            println("occurrence: $occurrence errors: $errors")
        }
    }
}