package com.conymind.backend.entity

import com.conymind.backend.model.DiaryTag
import com.conymind.backend.model.TagType
import jakarta.persistence.*

@Entity
@Table(name = "diary_tag")
data class DiaryTagEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name", nullable = false, length = 128)
    val name: String,

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    val type: TagType
){
    fun toDomain(): DiaryTag {
        return DiaryTag(
            id = id ?: throw IllegalArgumentException("Tag ID cannot be null"),
            name = name,
            type = type
        )
    }
}