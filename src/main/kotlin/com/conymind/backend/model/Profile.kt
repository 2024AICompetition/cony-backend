package com.conymind.backend.model

import com.conymind.backend.entity.ProfileEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

data class Profile(
    val uid: String,
    val displayName: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)

fun ProfileEntity.toDomain() = Profile(
    uid = this.uid!!,
    displayName = this.displayName,
    createdAt = this.createdAt!!,
    updatedAt = this.updatedAt!!
)