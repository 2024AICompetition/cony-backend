package com.conymind.backend.repository

import com.conymind.backend.entity.TaskEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository : JpaRepository<TaskEntity, Long> {
    fun findAllByProfileUid(uid: String): List<TaskEntity>
}
