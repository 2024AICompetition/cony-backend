package com.conymind.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ConyBackendApplication

fun main(args: Array<String>) {
    runApplication<ConyBackendApplication>(*args)
}
