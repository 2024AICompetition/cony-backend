package com.conymind.backend.util

fun mapWeatherToIcon(weatherGroup: String): String? {
    return when (weatherGroup) {
        "Thunderstorm" -> "/images/thunderstorm.png"
        "Drizzle" -> "/images/rainy.png"
        "Rain" -> "/images/rainy.png"
        "Snow" -> "/images/weather_snowy.png"
        "Clear" -> "/images/clear_day.png"
        "Clouds" -> "/images/foggy.png"
        "Atmosphere" -> "/images/foggy.png"
        "Mist" -> "/images/foggy.png"
        else ->  "/images/foggy.png"
    }
}