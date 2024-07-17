package com.conymind.backend.entity

import jakarta.persistence.*

@Entity
@Table(name = "suggest_question_category")
data class SuggestQuestionCategoryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "text", nullable = false, length = 50)
    val text: String
)

fun SuggestQuestionCategoryEntity.toModel() = com.conymind.backend.model.SuggestQuestionCategory(
    id = id,
    text = text
)