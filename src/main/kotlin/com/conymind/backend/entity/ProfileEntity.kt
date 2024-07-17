package com.conymind.backend.entity

import com.conymind.backend.model.Profile
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "profile")
data class ProfileEntity(
    @Id
    @Column(name = "uid", nullable = false, length = 128)
    val uid: String? = null,

    @Column(name = "display_name", nullable = false, length = 50)
    var displayName: String,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    var createdAt: LocalDateTime? = null,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime? = null
)

fun ProfileEntity.toProfile() = Profile(
    uid = this.uid!!,
    displayName = this.displayName,
    createdAt = this.createdAt!!,
    updatedAt = this.updatedAt!!
)