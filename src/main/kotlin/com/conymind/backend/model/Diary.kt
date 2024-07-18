package com.conymind.backend.model

import java.time.LocalDateTime
import java.util.Date

data class Diary(
    val id: Long,
    val profile: Profile,
    val createdAt: LocalDateTime,
    val modifiedAt: LocalDateTime,
    val title: String?,
    val contents: String,
    val weather: Weather?,
    val tags: Set<DiaryTag>,
    val topics: Set<DiaryTopic>
)