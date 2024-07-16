package com.conymind.backend.lib

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.FileInputStream
import java.io.IOException


@Service
class FirebaseService {
    private val logger = LoggerFactory.getLogger(FirebaseService::class.java)

    @Value("\${cony.firebase.config.path}")
    private lateinit var firebaseConfigPath: String

    @jakarta.annotation.PostConstruct
    fun initializeFirebase() {
        try {
            logger.info("Firebase config path: $firebaseConfigPath")

            if (firebaseConfigPath.isBlank()) {
                throw IllegalArgumentException("CONY_FIREBASE_CONFIG_PATH environment variable is not set")
            }

            val serviceAccount = FileInputStream(firebaseConfigPath)
            val options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build()

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options)
                logger.info("Firebase has been initialized")
            } else {
                logger.info("Firebase is already initialized")
            }
        } catch (e: IOException) {
            logger.error("Error initializing Firebase", e)
            throw RuntimeException("Could not initialize Firebase", e)
        } catch (e: IllegalArgumentException) {
            logger.error("Error with Firebase configuration", e)
            throw RuntimeException("Invalid Firebase configuration", e)
        }
    }
}