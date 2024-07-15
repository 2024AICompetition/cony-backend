package com.conymind.backend.config

import com.conymind.backend.security.FirebaseAuthenticationFilter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Value("\${debug.mode.token}")
    var debugModeToken : String? = null

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {

        val filter = FirebaseAuthenticationFilter(debugModeToken)

        http
            .csrf { csrf -> csrf.disable()
            }
            .authorizeHttpRequests {
                it.requestMatchers("/public/**").permitAll()
                it.anyRequest().authenticated()
            }
            .addFilterBefore(filter, UsernamePasswordAuthenticationFilter::class.java)
            .sessionManagement {
                it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            .securityContext {
                it.disable()
            }

        return http.build()
    }
}