package com.conymind.backend.externalapi

import feign.QueryMap
import feign.RequestLine

interface OpenWeatherMapAPI {
    @RequestLine("GET /data/3.0/onecall")
    fun getOneCall(@QueryMap openWeatherMapRequest: OneCallRequest): CurrentWeatherData
}