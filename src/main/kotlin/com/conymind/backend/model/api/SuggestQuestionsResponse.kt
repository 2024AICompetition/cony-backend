package com.conymind.backend.model.api

import com.conymind.backend.model.SuggestQuestion
import com.conymind.backend.model.SuggestQuestionCategory

data class SuggestQuestionsResponse(
    val categories: List<SuggestQuestionCategory>,
    val suggestQuestions: Map<Long, List<SuggestQuestion>>
)