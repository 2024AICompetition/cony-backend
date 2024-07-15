package com.conymind.backend.controller

import com.conymind.backend.externalapi.*
import com.conymind.backend.model.Weather
import com.conymind.backend.security.FirebaseUserDetails
import com.conymind.backend.service.WeatherService
import feign.Feign
import feign.gson.GsonDecoder
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/weather")
class WeatherController(private val weatherSerivce: WeatherService) {

    @GetMapping
    fun getWeather(
        @AuthenticationPrincipal userDetails: FirebaseUserDetails,
        @RequestParam lat: Double,
        @RequestParam lng: Double
    ): Weather {
        return weatherSerivce.getWeatherAndLocation(lat, lng)
    }
}