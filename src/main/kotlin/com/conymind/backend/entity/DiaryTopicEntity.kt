package com.conymind.backend.entity

import com.conymind.backend.model.DiaryTopic
import jakarta.persistence.*

@Entity
@Table(name = "diary_topic")
data class DiaryTopicEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name", nullable = false, length = 128)
    val name: String
){
    fun toDomain(): DiaryTopic {
        return DiaryTopic(
            id = id ?: throw IllegalArgumentException("Topic ID cannot be null"),
            name = name
        )
    }
}