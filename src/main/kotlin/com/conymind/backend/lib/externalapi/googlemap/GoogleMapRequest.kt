package com.conymind.backend.lib.externalapi.googlemap

data class ReverseGeocodingRequest(
    val latlng : String,
    val key: String
) {
}