package com.conymind.backend.externalapi

data class OneCallRequest(
    val lat: Double,
    val lon: Double,
    val appid: String,
    val exclude: String,
    val lang : String = "kr",
) {
}