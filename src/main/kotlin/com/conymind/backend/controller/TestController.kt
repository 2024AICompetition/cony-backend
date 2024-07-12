package com.conymind.backend.controller

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ApiController {

    @GetMapping("/public")
    fun publicEndpoint(): String {
        return "This is a public endpoint."
    }

    @GetMapping("/private")
    fun privateEndpoint(): String {
        val authentication = SecurityContextHolder.getContext().authentication
        val uid = authentication.principal as String

        return "This is a private endpoint. Only authenticated users can access this. $uid"
    }
}