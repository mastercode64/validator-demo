package com.mastercode.validatordemo.model

data class Occurrence(
    val entityId: String,
    val value: Long,
    val type: OccurrenceType,
    val description: String,
)
