package jp.co.archive.copo.data.model

import java.util.Date

data class Event(
    val adminId: String,
    val title: String,
    val description: String,
    val createdAt: Date
)