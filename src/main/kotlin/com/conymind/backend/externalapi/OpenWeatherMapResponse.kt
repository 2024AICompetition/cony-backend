package com.conymind.backend.externalapi

data class Location(
    val name: String,
    val localNames: Map<String, String>,
    val lat: Double,
    val lon: Double,
    val country: String
)

data class CurrentWeatherData(
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezoneOffset: Int,
    val current: CurrentWeather
)

data class CurrentWeather(
    val dt: Int,
    val sunrise: Int,
    val sunset: Int,
    val temp: Double,
    val feelsLike: Double,
    val pressure: Int,
    val humidity: Int,
    val dewPoint: Double,
    val uvi: Double,
    val clouds: Int,
    val visibility: Int,
    val windSpeed: Double,
    val windDeg: Int,
    val weather: List<Weather>
)

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)