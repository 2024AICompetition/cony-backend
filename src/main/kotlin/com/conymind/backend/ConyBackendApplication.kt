package com.conymind.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
class ConyBackendApplication

fun main(args: Array<String>) {
    runApplication<ConyBackendApplication>(*args)
}
