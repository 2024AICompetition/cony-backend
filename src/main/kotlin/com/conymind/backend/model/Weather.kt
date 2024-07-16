package com.conymind.backend.model

import com.conymind.backend.entity.WeatherEntity
import jakarta.persistence.*
import java.time.LocalDateTime

class Weather(
    val id: Long,
    val temperature: Double,
    val weather: String,
    val latitude: Double,
    val longitude: Double,
    val address: String,
    val createdAt: LocalDateTime? = null
) {

}

fun WeatherEntity.toDomain() = Weather(
    id = this.id,
    temperature = this.temperature,
    weather = this.weather,
    latitude = this.latitude,
    longitude = this.longitude,
    address = this.address,
    createdAt = this.createdAt
)