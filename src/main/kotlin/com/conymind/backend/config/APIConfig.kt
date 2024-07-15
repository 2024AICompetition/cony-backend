package com.conymind.backend.config

import com.conymind.backend.externalapi.GoogleMapAPI
import com.conymind.backend.externalapi.OpenWeatherMapAPI
import feign.Feign
import feign.gson.GsonDecoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class APIConfig {
    @Bean
    fun googleMapAPI(): GoogleMapAPI {
        return Feign.builder()
            .decoder(GsonDecoder())
            .target(GoogleMapAPI::class.java, "https://maps.googleapis.com")
    }

    @Bean
    fun openWeatherMapAPI(): OpenWeatherMapAPI {
        return Feign.builder()
            .decoder(GsonDecoder())
            .target(OpenWeatherMapAPI::class.java, "https://api.openweathermap.org")
    }
}