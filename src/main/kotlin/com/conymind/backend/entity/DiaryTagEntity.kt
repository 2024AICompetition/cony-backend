package com.conymind.backend.entity

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

}

enum class TagType {
    EMOTION, PERSON, EVENT, PLACE
}