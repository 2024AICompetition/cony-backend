package com.conymind.backend.lib

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.io.FileInputStream
import java.io.IOException


@Service
class FirebaseService {
    private val logger = LoggerFactory.getLogger(FirebaseService::class.java)

    @jakarta.annotation.PostConstruct
    fun initializeFirebase() {
        try {
            val path = System.getenv("CONY_FIREBASE_CONFIG_PATH")
            logger.info("Firebase config path: $path")

            if (path.isNullOrBlank()) {
                throw IllegalArgumentException("CONY_FIREBASE_CONFIG_PATH environment variable is not set")
            }

            val serviceAccount = FileInputStream(path)
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