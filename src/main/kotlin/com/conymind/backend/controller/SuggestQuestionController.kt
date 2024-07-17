package com.conymind.backend.controller

import com.conymind.backend.entity.SuggestQuestionCategoryEntity
import com.conymind.backend.entity.SuggestQuestionEntity
import com.conymind.backend.model.SuggestQuestion
import com.conymind.backend.model.SuggestQuestionCategory
import com.conymind.backend.model.api.SuggestQuestionsResponse
import com.conymind.backend.security.FirebaseUserDetails
import com.conymind.backend.service.SuggestQuestionService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/suggest-questions")
class SuggestQuestionController(private val suggestQuestionService: SuggestQuestionService) {
    @GetMapping
    fun getSuggestQuestions(@AuthenticationPrincipal userDetails: FirebaseUserDetails): SuggestQuestionsResponse {
        val suggestQuestionsMap = suggestQuestionService.loadSuggestQuestions(userDetails.uid)

        val categories = suggestQuestionsMap.keys.toList()
        val suggestQuestions = suggestQuestionsMap.mapKeys { it.key.id }

        return SuggestQuestionsResponse(
            categories = categories,
            suggestQuestions = suggestQuestions
        )
    }
}
