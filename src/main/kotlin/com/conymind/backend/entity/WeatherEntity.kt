package com.conymind.backend.entity

import com.conymind.backend.model.Language
import jakarta.persistence.*
import org.apache.commons.codec.language.bm.Lang
import java.time.LocalDateTime

@Table(name = "weather")
@Entity
data class WeatherEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "temperature", nullable = false)
    val temperature: Double,

    @Column(name = "weather", nullable = false)
    val weather: String,

    @Column(name = "description", nullable = false)
    val description: String,

    @Column(name = "latitude", nullable = false)
    val latitude: Double,

    @Column(name = "longitude", nullable = false)
    val longitude: Double,

    @Column(name = "address", nullable = false)
    val address: String,

    @Column(name = "lang", nullable = false)
    @Enumerated(EnumType.STRING)
    val lang: Language,

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    var createdAt: LocalDateTime? = null,
)