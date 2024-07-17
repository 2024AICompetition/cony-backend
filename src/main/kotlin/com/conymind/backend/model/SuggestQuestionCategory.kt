package com.conymind.backend.model

import java.time.LocalDateTime

data class SuggestQuestionCategory(
    val id: Long,
    val text: String
)

data class SuggestQuestion(
    val id: Long,
    val content: String,
    val isPersonalized: Boolean,
    val expirationDate: LocalDateTime?,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)