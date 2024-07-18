package com.conymind.backend.service

import com.conymind.backend.entity.DiaryEntity
import com.conymind.backend.entity.RecordEntity
import com.conymind.backend.entity.SuggestQuestionCategoryEntity
import com.conymind.backend.entity.SuggestQuestionEntity
import com.conymind.backend.repository.*
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class RecordService(
    private val recordRepository: RecordRepository,
    private val diaryRepository: DiaryRepository,
    private val profileRepository: ProfileRepository,
    private val suggestQuestionRepository: SuggestQuestionRepository,
    private val suggestQuestionCategoryRepository: SuggestQuestionCategoryRepository
) {

    fun getRecord(id: Long): RecordEntity {
        return recordRepository.findById(id).getOrNull()
            ?: throw IllegalArgumentException("Invalid record ID")
    }

    fun createRecord(uid: String, currentFocusQuestionId: Long?, currentFocusQuestionCategoryId: Long?): RecordEntity {
        val profile = profileRepository.findByUid(uid) ?: throw IllegalArgumentException("Invalid user")

        val record = RecordEntity(
            profile = profile,
            currentTranscript = "",
            currentFocusQuestion = if (currentFocusQuestionId != null) suggestQuestionRepository.findById(currentFocusQuestionId).getOrNull() else null,
            currentFocusQuestionCategory = if (currentFocusQuestionCategoryId != null) suggestQuestionCategoryRepository.findById(currentFocusQuestionCategoryId).getOrNull() else null
        )

        return recordRepository.save(record)
    }

    fun updateTranscript(id: Long, transcript: String): RecordEntity {
        val record = recordRepository.findById(id).getOrNull()
            ?: throw IllegalArgumentException("Invalid record ID")

        record.currentTranscript = transcript

        return recordRepository.save(record)
    }
}