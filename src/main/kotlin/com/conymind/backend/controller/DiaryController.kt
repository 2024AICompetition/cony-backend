package com.conymind.backend.controller

import com.conymind.backend.entity.DiaryEntity
import com.conymind.backend.service.DiaryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/diaries")
class DiaryController(
    private val diaryService: DiaryService
) {
    /*@GetMapping("/")
    fun getDiaries(): List<DiaryEntity> {
        return "This is a public endpoint."
    }*/

    @GetMapping("/diary-filter-list")
    fun getDairyFilterList(): List<String> {
        return diaryService.getDiaryFilterList()
    }
}