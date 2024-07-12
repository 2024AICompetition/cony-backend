package com.conymind.backend.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "profile")
data class Profile(
    @Id
    @Column(name = "uid", nullable = false, length = 255)
    val uid: String? = null,

    @Column(name = "first_name", nullable = false, length = 255)
    var firstName: String,

    @Column(name = "last_name", nullable = false, length = 255)
    var lastName: String,

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    var createdAt: Date? = null,

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    var updatedAt: Date? = null
)