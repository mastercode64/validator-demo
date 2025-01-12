package com.mastercode.validatordemo

import com.mastercode.validatordemo.fixture.OccurrenceFixture.invalidTransactionOccurrence
import com.mastercode.validatordemo.services.OccurrenceService
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class Runner(
    private val validatorService: OccurrenceService
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        println("starting validation")
        val result = validatorService.process(invalidTransactionOccurrence)
        println(result)
    }
}