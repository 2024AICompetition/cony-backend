package com.conymind.backend.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

data class Task(
    val id: Long,
    val content: String,
    val completed: Boolean,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)