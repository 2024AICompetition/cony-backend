package com.conymind.backend.security

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseToken
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException

class FirebaseAuthenticationFilter : OncePerRequestFilter() {

    @Throws(IOException::class, ServletException::class)
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        val token = request.getHeader("Authorization")

        if (token != null && token.startsWith("Bearer ")) {
            val decodedToken: FirebaseToken? = try {
                FirebaseAuth.getInstance().verifyIdToken(token.substring(7))
            } catch (e: FirebaseAuthException) {
                throw RuntimeException(e)
            }

            if (decodedToken != null) {
                val userDetails = FirebaseUserDetails(decodedToken.email, decodedToken.uid)
                val authentication = UsernamePasswordAuthenticationToken(userDetails, null, emptyList())
                SecurityContextHolder.getContext().authentication = authentication
            }
        }

        chain.doFilter(request, response)
    }
}