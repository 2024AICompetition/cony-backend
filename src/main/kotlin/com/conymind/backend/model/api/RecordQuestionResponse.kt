package com.conymind.backend.model.api

import org.aspectj.weaver.patterns.TypePatternQuestions.Question

data class RecordQuestionResponse(
    val id: Long,
    val questions: Map<String, List<String>>
) {
}