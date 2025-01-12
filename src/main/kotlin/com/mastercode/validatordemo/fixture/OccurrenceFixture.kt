package com.mastercode.validatordemo.fixture

import com.mastercode.validatordemo.model.Occurrence
import com.mastercode.validatordemo.model.OccurrenceType

object OccurrenceFixture {
    val orderOccurrence = Occurrence(
        type = OccurrenceType.ORDER,
        entityId = "1",
        value = 5,
        description = "order 7"
    )

    val periodOccurrence = Occurrence(
        type = OccurrenceType.PERIOD,
        entityId = "2",
        value = 3,
        description = "period April"
    )

    val transactionOccurrence = Occurrence(
        type = OccurrenceType.TRANSACTION,
        entityId = "3",
        value = 10,
        description = "test transaction"
    )

    val invalidTransactionOccurrence = Occurrence(
        type = OccurrenceType.TRANSACTION,
        entityId = "1",
        value = 0,
        description = "test transaction"
    )
}