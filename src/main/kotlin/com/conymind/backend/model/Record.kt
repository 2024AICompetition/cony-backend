package com.conymind.backend.model

import java.time.LocalDateTime

data class Record(
    val id: Long,
    val profileUid: String,
    val createdAt: LocalDateTime?,
    val modifiedAt: LocalDateTime?,
    val currentTranscript: String,
    val answeredQuestions: Set<SuggestQuestion>,
    val currentFocusQuestion: SuggestQuestion?,
    val currentFocusQuestionCategory: SuggestQuestionCategory?
)