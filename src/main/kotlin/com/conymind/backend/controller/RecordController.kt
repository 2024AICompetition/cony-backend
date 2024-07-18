package com.conymind.backend.controller

import com.conymind.backend.entity.DiaryEntity
import com.conymind.backend.entity.RecordEntity
import com.conymind.backend.entity.toDomain
import com.conymind.backend.model.Diary
import com.conymind.backend.model.Language
import com.conymind.backend.model.Record
import com.conymind.backend.model.api.CreateRecordRequest
import com.conymind.backend.model.api.UpdateTranscriptRequest
import com.conymind.backend.security.FirebaseUserDetails
import com.conymind.backend.service.DiaryService
import com.conymind.backend.service.RecordService
import com.conymind.backend.service.WeatherService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/records")
class RecordController(private val recordService: RecordService, private val diaryService: DiaryService, private val weatherService : WeatherService) {

    @GetMapping("/{id}")
    fun getRecord(
        @AuthenticationPrincipal userDetails: FirebaseUserDetails,
        @PathVariable id: Long
    ): RecordEntity {
        return recordService.getRecord(id = id)
    }

    @PostMapping
    fun createRecord(
        @AuthenticationPrincipal userDetails: FirebaseUserDetails,
        @RequestBody createRecordRequest: CreateRecordRequest
    ): RecordEntity =
        recordService.createRecord(
            uid = userDetails.uid,
            currentFocusQuestionId = createRecordRequest.focusQuestionId,
            currentFocusQuestionCategoryId = createRecordRequest.focusQuestionCategoryId
        )

    @PutMapping("/{id}/transcript")
    fun updateTranscript(
        @AuthenticationPrincipal userDetails: FirebaseUserDetails,
        @PathVariable id: Long,
        @RequestBody updateTranscriptRequest: UpdateTranscriptRequest,
    ): Record {
        val record = recordService.getRecord(id = id)
        if (record.profile.uid != userDetails.uid) {
            throw IllegalArgumentException("Invalid user")
        }

        return recordService.updateTranscript(
            id = id,
            transcript = updateTranscriptRequest.transcript
        ).toDomain()
    }

    @PutMapping("/{id}/skip-question")
    fun skipQuestion(
        @AuthenticationPrincipal userDetails: FirebaseUserDetails,
        @PathVariable id: Long,
        @RequestBody updateTranscriptRequest: UpdateTranscriptRequest,
    ): Record {
        val record = recordService.getRecord(id = id)
        if (record.profile.uid != userDetails.uid) {
            throw IllegalArgumentException("Invalid user")
        }

        return recordService.skipQuestion(
            id = id,
        ).toDomain()
    }

    @PostMapping("/{id}/convert-to-diary")
    fun convertToDiary(
        @AuthenticationPrincipal userDetails: FirebaseUserDetails,
        @PathVariable id: Long,
        @RequestParam lat: Double,
        @RequestParam lng: Double,
        @RequestParam lang: Language
    ): Diary {
        val record = recordService.getRecord(id = id)
        val weatherId = try {
            weatherService.getWeatherAndLocation(lat, lng, lang).id
        } catch (e: Exception) {
            null
        }

        if (record.profile.uid != userDetails.uid) {
            throw IllegalArgumentException("Invalid user")
        }

        return diaryService.convertRecordToDiary(record, weatherId)
    }

}