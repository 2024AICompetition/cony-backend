package com.conymind.backend.util

fun fahrenheitToCelsius(fahrenheit: Double): Double {
    return (fahrenheit - 32) * 5 / 9
}

fun kelvinToCelsius(kelvin: Double): Double {
    return kelvin - 273.15
}