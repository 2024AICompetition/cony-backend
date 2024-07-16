package com.conymind.backend.service

import com.conymind.backend.entity.WeatherEntity
import com.conymind.backend.lib.externalapi.googlemap.GoogleMapAPI
import com.conymind.backend.lib.externalapi.openweathermap.OneCallRequest
import com.conymind.backend.lib.externalapi.openweathermap.OpenWeatherMapAPI
import com.conymind.backend.lib.externalapi.googlemap.ReverseGeocodingRequest
import com.conymind.backend.model.Weather
import com.conymind.backend.model.toDomain
import com.conymind.backend.repository.WeatherRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.time.LocalDateTime


@Service
class WeatherService(
    private val googleMapAPI: GoogleMapAPI,
    private val openWeatherMapAPI : OpenWeatherMapAPI,
    private val weatherRepository: WeatherRepository
) {
    @Value("\${openweathermap.api.key}")
    private lateinit var openWeatherMapAPIKey: String

    @Value("\${googlemap.api.key}")
    private lateinit var googleMapAPIKey: String

    fun getWeatherAndLocation(latitude : Double, longitude : Double) : Weather {
        val weather = openWeatherMapAPI.getOneCall(
            OneCallRequest(
                latitude,
                longitude,
                openWeatherMapAPIKey,
                "minutely,hourly,daily,alerts"
            )
        )

        val geo = googleMapAPI.getReverseGeocoding(
            ReverseGeocodingRequest(
                "$latitude,$longitude",
                googleMapAPIKey
            )
        )

        val weatherEntity : WeatherEntity = weatherRepository.save(WeatherEntity(
            0,
            weather.current.temp,
            weather.current.weather[0].description,
            latitude,
            longitude,
            geo.formattedAddress ?: "Unknown Location",
            LocalDateTime.now()
        ))

        return weatherEntity.toDomain()
    }
}