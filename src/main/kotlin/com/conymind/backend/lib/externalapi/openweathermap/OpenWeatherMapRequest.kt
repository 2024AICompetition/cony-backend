package com.conymind.backend.lib.externalapi.openweathermap

data class OneCallRequest(
    val lat: Double,
    val lon: Double,
    val appid: String,
    val exclude: String,
    val lang : String,
) {
}