package com.conymind.backend.repository

import com.conymind.backend.entity.DiaryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DiaryRepository : JpaRepository<DiaryEntity, Long> {
}