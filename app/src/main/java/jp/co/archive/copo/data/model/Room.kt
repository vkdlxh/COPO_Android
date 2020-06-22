package jp.co.archive.copo.data.model

import java.util.Date

data class Room(
    val adminId: String,
    val title: String,
    val description: String,
    val createAt: Date
)