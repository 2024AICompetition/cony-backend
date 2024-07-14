package com.conymind.backend.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "diary")
data class DiaryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "authorUid", nullable = false, length = 128)
    val authorId: String,

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    var createdAt: LocalDateTime? = null,

    @Column(
        name = "updated_at",
        nullable = false,
        columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP"
    )
    var modifiedAt: LocalDateTime? = null,

    @Column(name = "title", length = 50, nullable = true)
    var title: String? = null,

    @Column(name = "contents", columnDefinition = "TEXT", nullable = false)
    var contents: String,

    @ManyToOne
    @JoinColumn(name = "weather_id", referencedColumnName = "id")
    val weather : WeatherEntity?
)