package com.conymind.backend.repository

import com.conymind.backend.entity.RecordEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface RecordRepository : JpaRepository<RecordEntity, Long> {
}