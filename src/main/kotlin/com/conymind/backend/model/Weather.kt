package com.conymind.backend.model

import com.conymind.backend.entity.WeatherEntity
import com.conymind.backend.util.mapWeatherToIcon
import jakarta.persistence.*
import java.time.LocalDateTime

class Weather(
    val id: Long,
    val temperature: Double,
    val weather: String,
    val description : String,
    val latitude: Double,
    val longitude: Double,
    val address: String,
    val icon: String?,
    val createdAt: LocalDateTime? = null
) {

}

fun WeatherEntity.toDomain() = Weather(
    id = this.id,
    temperature = this.temperature,
    weather = this.weather,
    description = this.description,
    latitude = this.latitude,
    longitude = this.longitude,
    address = this.address,
    icon = mapWeatherToIcon(this.weather),
    createdAt = this.createdAt
)