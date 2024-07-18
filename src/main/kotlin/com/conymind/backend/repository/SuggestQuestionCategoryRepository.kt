package com.conymind.backend.repository

import com.conymind.backend.entity.SuggestQuestionCategoryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SuggestQuestionCategoryRepository : JpaRepository<SuggestQuestionCategoryEntity, Long> {
}