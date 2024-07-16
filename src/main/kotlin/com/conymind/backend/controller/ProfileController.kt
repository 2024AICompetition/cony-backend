package com.conymind.backend.controller

import com.conymind.backend.model.Profile
import com.conymind.backend.repository.ProfileRepository
import com.conymind.backend.security.FirebaseUserDetails
import com.conymind.backend.service.ProfileService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/profiles")
class ProfileController(private val profileService: ProfileService) {
    @GetMapping("/me")
    fun getProfile(
        @AuthenticationPrincipal userDetails: FirebaseUserDetails,
    ): Profile {
        return profileService.getProfile(userDetails.uid)
    }
}