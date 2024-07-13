package com.conymind.backend.lib

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service
import java.io.FileInputStream
import java.io.IOException

@Service
class FirebaseService {
    @PostConstruct
    fun initializeFirebase() {
        try {
            val path = System.getenv("CONY_FIREBASE_CONFIG_PATH")
            val serviceAccount = FileInputStream(path)
            val options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build()
            FirebaseApp.initializeApp(options)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}