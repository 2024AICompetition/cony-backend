package com.conymind.backend.model

import java.time.LocalDateTime
import java.util.Date

data class Diary(
    val id: Long,
    val title: String,
    val contents: String,
    val authorId: String,
    val createdAt: LocalDateTime,
    val modifiedAt: LocalDateTime,
    val weather: Weather
) {

}