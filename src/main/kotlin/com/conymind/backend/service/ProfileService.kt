package com.conymind.backend.service

import com.conymind.backend.exception.ConyHttpError
import com.conymind.backend.exception.ConyRuntimeException
import com.conymind.backend.model.Profile
import com.conymind.backend.model.toDomain
import com.conymind.backend.repository.ProfileRepository
import org.springframework.stereotype.Service

@Service
class ProfileService(val profileRepository: ProfileRepository) {
    fun getProfile(uid: String): Profile {
        return profileRepository.findByUid(uid)?.toDomain()
            ?: throw ConyRuntimeException(conyHttpError = ConyHttpError.ENTITY_NOT_FOUND_EXCEPTION)
    }
}