package com.conymind.backend.repository

import com.conymind.backend.entity.WeatherEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WeatherRepository : JpaRepository<WeatherEntity, Long>{
}