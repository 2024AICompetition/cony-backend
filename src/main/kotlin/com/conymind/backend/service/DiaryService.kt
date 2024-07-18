package com.conymind.backend.service

import com.conymind.backend.entity.DiaryEntity
import com.conymind.backend.entity.RecordEntity
import com.conymind.backend.model.Diary
import com.conymind.backend.repository.DiaryRepository
import com.conymind.backend.repository.WeatherRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class DiaryService(private val diaryRepository: DiaryRepository, private val weatherRepository: WeatherRepository) {
    fun convertRecordToDiary(record: RecordEntity, weatherId: Long?): Diary {
        val diary = DiaryEntity(
            profile = record.profile,
            createdAt = record.createdAt,
            modifiedAt = record.modifiedAt,
            title = generateTitleFromTranscript(record.currentTranscript),
            contents = record.currentTranscript,
            weather = weatherId?.let { weatherRepository.findById(it).getOrNull() },
            tags = emptySet(),
            topics = emptySet()
        )

        return diaryRepository.save(diary).toDomain()
    }

    private fun generateTitleFromTranscript(transcript: String): String {
        return transcript.split(" ").take(5).joinToString(" ") + "..."
    }
}