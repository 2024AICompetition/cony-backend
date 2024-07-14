package com.conymind.backend.model

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