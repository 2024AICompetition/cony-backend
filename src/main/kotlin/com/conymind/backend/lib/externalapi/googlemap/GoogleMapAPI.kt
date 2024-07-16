package com.conymind.backend.lib.externalapi.googlemap

import feign.QueryMap
import feign.RequestLine

interface GoogleMapAPI {
    @RequestLine("GET /maps/api/geocode/json")
    fun getReverseGeocoding(@QueryMap googleMapRequest: ReverseGeocodingRequest): GeocodeResponse
}
