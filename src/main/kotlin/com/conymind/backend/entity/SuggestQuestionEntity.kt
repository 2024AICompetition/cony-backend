package com.conymind.backend.entity

import com.conymind.backend.model.SuggestQuestion
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "suggest_question")
data class SuggestQuestionEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "content", nullable = false, length = 500)
    val content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    val category: SuggestQuestionCategoryEntity,

    @Column(name = "is_personalized", nullable = false)
    val isPersonalized: Boolean,

    @Column(name = "expiration_date")
    val expirationDate: LocalDateTime? = null,

    @CreationTimestamp
    @Column(name = "created_at", nullable = true, updatable = false)
    var createdAt: LocalDateTime? = null,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = true)
    var updatedAt: LocalDateTime? = null
)

fun SuggestQuestionEntity.toModel() = SuggestQuestion(
    id = id,
    content = content,
    isPersonalized = isPersonalized,
    expirationDate = expirationDate,
    createdAt = createdAt!!,
    updatedAt = updatedAt!!
)