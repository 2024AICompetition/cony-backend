package com.conymind.backend.controller

import com.conymind.backend.security.FirebaseUserDetails
import org.springframework.security.core.annotation.AuthenticationPrincipal
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
    fun privateEndpoint(@AuthenticationPrincipal userDetails: FirebaseUserDetails): String {
        return userDetails.username
    }
}