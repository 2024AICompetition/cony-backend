package com.conymind.backend.entity

import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name = "profile_suggest_question")
data class ProfileSuggestQuestionEntity(
    @EmbeddedId
    val id: ProfileSuggestQuestionId,

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("uid")
    @JoinColumn(name = "uid")
    val profile: ProfileEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("suggestQuestionId")
    @JoinColumn(name = "suggest_question_id")
    val suggestQuestion: SuggestQuestionEntity
)

@Embeddable
data class ProfileSuggestQuestionId(
    @Column(name = "uid")
    val uid: String,

    @Column(name = "suggest_question_id")
    val suggestQuestionId: Long
) : Serializable