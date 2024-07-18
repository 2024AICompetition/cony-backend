package com.conymind.backend.repository

import com.conymind.backend.entity.DiaryEntity
import com.conymind.backend.entity.DiaryTagEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DiaryTagRepository : JpaRepository<DiaryTagEntity, Long> {
}