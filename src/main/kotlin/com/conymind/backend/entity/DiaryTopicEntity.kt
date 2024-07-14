package com.conymind.backend.entity

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

}