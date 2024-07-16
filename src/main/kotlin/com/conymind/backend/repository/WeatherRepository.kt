package com.conymind.backend.repository

import com.conymind.backend.entity.WeatherEntity
import com.conymind.backend.model.Language
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.LocalDateTime


@Repository
interface WeatherRepository : JpaRepository<WeatherEntity, Long>{
    @Query(nativeQuery = true, value = """
        SELECT *,
        (6371 * acos(
            cos(radians(:latitude)) *
            cos(radians(latitude)) *
            cos(radians(longitude) - radians(:longitude)) +
            sin(radians(:latitude)) *
            sin(radians(latitude))
        )) AS distance
        FROM weather
        WHERE lang = :lang 
        AND created_at > :sixHoursAgo
        HAVING distance <= 0.2
        ORDER BY distance
        LIMIT 1
    """)
    fun findNearestRecentWeather(
        @Param("latitude") latitude: Double,
        @Param("longitude") longitude: Double,
        @Param("lang") lang: String,
        @Param("sixHoursAgo") sixHoursAgo: LocalDateTime
    ): WeatherEntity?
}