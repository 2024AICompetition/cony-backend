package com.conymind.backend.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "profile")
data class ProfileEntity(
    @Id
    @Column(name = "uid", nullable = false, length = 128)
    val uid: String? = null,

    @Column(name = "display_name", nullable = false, length = 50)
    var displayName: String,

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    var createdAt: LocalDateTime? = null,

    @Column(
        name = "updated_at",
        nullable = false,
        columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP"
    )
    var updatedAt: LocalDateTime? = null
)