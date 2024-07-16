package com.conymind.backend.controller

import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class ImageController {
    @GetMapping("/images/{filename:.+}")
    fun serveImage(@PathVariable filename: String): ResponseEntity<Resource> {
        val file: Resource = ClassPathResource("static/images/$filename")
        return if (file.exists()) {
            ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE)
                .body(file)
        } else {
            ResponseEntity.notFound().build<Resource>()
        }
    }
}