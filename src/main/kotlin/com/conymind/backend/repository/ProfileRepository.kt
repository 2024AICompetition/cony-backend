package com.conymind.backend.repository

import com.conymind.backend.entity.ProfileEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProfileRepository : JpaRepository<ProfileEntity, Long> {
    fun findByUid(uid: String): ProfileEntity?
}