package com.conymind.backend.entity

import com.conymind.backend.model.Task
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "task")
data class TaskEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "author_uid", referencedColumnName = "uid")
    val profile: ProfileEntity,

    @Column(nullable = false)
    var content: String,

    @Column(nullable = false)
    var completed: Boolean = false,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    var createdAt: LocalDateTime? = null,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime? = null
)


fun TaskEntity.toTask() = Task(
    id = id,
    content = content,
    completed = completed,
    createdAt = createdAt!!,
    updatedAt = updatedAt!!
)
