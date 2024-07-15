package com.conymind.backend.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig {
    @Bean(name = ["openWeatherMapWebClient"])
    fun webClient(builder: WebClient.Builder): WebClient {
        return builder.baseUrl("https://api.openweathermap.org").build()
    }
}