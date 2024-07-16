package com.conymind.backend.config

import com.conymind.backend.lib.externalapi.googlemap.GoogleMapAPI
import com.conymind.backend.lib.externalapi.openweathermap.OpenWeatherMapAPI
import feign.Feign
import feign.gson.GsonDecoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

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