package com.conymind.backend.externalapi

data class ReverseGeocodingRequest(
    val latlng : String,
    val key: String
) {
}