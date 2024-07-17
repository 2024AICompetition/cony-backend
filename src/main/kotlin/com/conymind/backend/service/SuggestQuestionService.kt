package com.conymind.backend.service

import com.conymind.backend.entity.toModel
import com.conymind.backend.model.SuggestQuestion
import com.conymind.backend.model.SuggestQuestionCategory
import com.conymind.backend.repository.SuggestQuestionRepository
import org.springframework.stereotype.Service

@Service
class SuggestQuestionService(
    private val suggestQuestionRepository: SuggestQuestionRepository
) {
    fun loadSuggestQuestions(uid: String): Map<SuggestQuestionCategory, List<SuggestQuestion>> {
        val generalQuestions = suggestQuestionRepository.findByIsPersonalizedFalse()
        val personalizedQuestions = suggestQuestionRepository.findPersonalizedQuestionsByUid(uid)
        val allQuestions = generalQuestions + personalizedQuestions

        return allQuestions.groupBy { it.category.toModel() }
            .mapValues { entry -> entry.value.map { it.toModel() } }
    }
}