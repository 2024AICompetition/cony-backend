package com.conymind.backend.model

data class Diary(
    val id: Long,
    val title: String,
    val contents: String,
    val authorId: String,
    val createdAt: String,
    val modifiedAt: String,
) {

}