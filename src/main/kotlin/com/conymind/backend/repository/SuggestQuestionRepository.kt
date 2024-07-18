package com.conymind.backend.repository

import com.conymind.backend.entity.SuggestQuestionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface SuggestQuestionRepository : JpaRepository<SuggestQuestionEntity, Long> {
    fun findByIsPersonalizedFalse(): List<SuggestQuestionEntity>

    @Query("SELECT sq FROM SuggestQuestionEntity sq JOIN ProfileSuggestQuestionEntity psq ON sq.id = psq.suggestQuestion.id WHERE psq.profile.uid = :uid AND sq.expirationDate > CURRENT_TIMESTAMP")
    fun findPersonalizedQuestionsByUid(@Param("uid") uid: String): List<SuggestQuestionEntity>

    @Query("SELECT sq FROM SuggestQuestionEntity sq WHERE sq.category.id = :category_id")
    fun findByCategoryId(@Param("category_id") categoryId: Long): List<SuggestQuestionEntity>
}