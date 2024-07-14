package com.conymind.backend.controller

import com.conymind.backend.entity.DiaryEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/diaries")
class DiaryController {
    /*@GetMapping("/")
    fun getDiaries(): List<DiaryEntity> {
        return "This is a public endpoint."
    }*/
}