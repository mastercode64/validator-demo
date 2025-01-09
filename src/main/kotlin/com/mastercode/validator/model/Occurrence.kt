package com.mastercode.validator.model

data class Occurrence(
    val entityId: String,
    val value: Long,
    val type: OccurrenceType,
)
