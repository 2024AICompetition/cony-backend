package com.conymind.backend.service

import com.conymind.backend.entity.WeatherEntity
import com.conymind.backend.externalapi.GoogleMapAPI
import com.conymind.backend.externalapi.OneCallRequest
import com.conymind.backend.externalapi.OpenWeatherMapAPI
import com.conymind.backend.externalapi.ReverseGeocodingRequest
import com.conymind.backend.model.Weather
import com.conymind.backend.repository.WeatherRepository
import feign.Feign
import feign.gson.GsonDecoder
import jakarta.persistence.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import reactor.core.publisher.Mono
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
                "AIzaSyCpU6AzatiiMlprXWpp4frwdXq8K533qmE"
            )
        )

        val weatherEntity : WeatherEntity = WeatherEntity(
            0,
            weather.current.temp,
            weather.current.weather[0].description,
            latitude,
            longitude,
            geo.formattedAddress ?: "Unknown Location",
            LocalDateTime.now()
        )

        weatherRepository.save(weatherEntity)

        return Weather(
            weatherEntity.id,
            weatherEntity.temperature,
            weatherEntity.weather,
            weatherEntity.latitude,
            weatherEntity.longitude,
            weatherEntity.address,
            weatherEntity.createdAt
        )
    }
}