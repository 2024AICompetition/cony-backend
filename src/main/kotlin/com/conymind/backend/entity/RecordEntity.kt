package com.conymind.backend.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "record")
data class RecordEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "profile_uid", referencedColumnName = "uid")
    val profile: ProfileEntity,

    @Column(name = "created_at", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    var createdAt: LocalDateTime? = null,

    @Column(
        name = "updated_at",
        nullable = true,
        columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP"
    )
    var modifiedAt: LocalDateTime? = null,

    @Column(name = "current_transcript", columnDefinition = "TEXT", nullable = false)
    var currentTranscript: String,

    @ManyToMany
    @JoinTable(
        name = "record_question_link",
        joinColumns = [JoinColumn(name = "record_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "question_id", referencedColumnName = "id")]
    )
    val answeredQuestions: Set<SuggestQuestionEntity> = mutableSetOf(),

    @ManyToOne
    @JoinColumn(name = "current_focus_question_id", referencedColumnName = "id")
    val currentFocusQuestion: SuggestQuestionEntity? = null,

    @ManyToOne
    @JoinColumn(name = "current_focus_question_category_id", referencedColumnName = "id")
    val currentFocusQuestionCategory: SuggestQuestionCategoryEntity? = null
)