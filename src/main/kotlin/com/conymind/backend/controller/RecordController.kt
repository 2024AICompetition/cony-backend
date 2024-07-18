package com.conymind.backend.controller

import com.conymind.backend.entity.DiaryEntity
import com.conymind.backend.entity.RecordEntity
import com.conymind.backend.model.api.CreateRecordRequest
import com.conymind.backend.model.api.UpdateTranscriptRequest
import com.conymind.backend.security.FirebaseUserDetails
import com.conymind.backend.service.RecordService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/records")
class RecordController(private val recordService: RecordService) {

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
    ): RecordEntity {
        val record = recordService.getRecord(id = id)
        if (record.profile.uid != userDetails.uid) {
            throw IllegalArgumentException("Invalid user")
        }

        return recordService.updateTranscript(
            id = id,
            transcript = updateTranscriptRequest.transcript
        )
    }
}