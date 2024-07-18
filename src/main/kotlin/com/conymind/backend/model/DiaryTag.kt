package com.conymind.backend.model

data class DiaryTag(
    val id: Long,
    val name: String,
    val type: TagType
)

enum class TagType {
    EMOTION, PERSON, EVENT, PLACE
}