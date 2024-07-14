package com.conymind.backend.entity

import jakarta.persistence.*
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

    @Column(name = "latitude", nullable = false)
    val latitude: Double,

    @Column(name = "longitude", nullable = false)
    val longitude: Double,

    @Column(name = "address", nullable = false)
    val address: String,

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    var createdAt: LocalDateTime? = null,
)