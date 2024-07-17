package com.conymind.backend.controller

import com.conymind.backend.model.api.RecordQuestionResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/questions")
class QuestionController {
    @GetMapping
    fun getQuestions(): RecordQuestionResponse {
        return RecordQuestionResponse(
            1, mapOf(
                "업무 생산성" to listOf(
                    "친구나 직장에서 동료에게 의욕을 북돋아준 일이 있었나요?",
                    "퇴근을 앞당기게 하는 사용자님의 비결은 무엇인가요?"
                ),
                "나의 감정" to listOf(
                    "오늘 하루 동안 가장 강렬했던 감정은 무엇이었나요?",
                    "어떤 상황이나 사람이 오늘 나의 감정을 가장 많이 변화시켰나요?",
                    "오늘 나를 가장 행복하게 만든 순간은 언제였나요?",
                    "오늘 나를 슬프게 혹은 화나게 한 것은 무엇인가요?"
                ),
                "새로운 취미" to listOf(
                    "최근에 시작한 새로운 취미가 있나요? 그 취미를 시작하게 된 계기는 무엇인가요?",
                    "새로운 취미를 통해 배운 것은 무엇인가요?",
                    "새로운 취미 활동 중 가장 즐거웠던 경험은 무엇인가요?",
                    "이 취미를 통해 만난 새로운 사람들이 있다면, 그들과의 만남이 어떠했나요?"
                )
            )
        )
    }
}