package com.conymind.backend.entity

import com.conymind.backend.model.Diary
import com.conymind.backend.model.toDomain
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "diary")
data class DiaryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "author_uid", referencedColumnName = "uid")
    val profile: ProfileEntity,

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    var createdAt: LocalDateTime? = null,

    @Column(
        name = "updated_at",
        nullable = false,
        columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP"
    )
    var modifiedAt: LocalDateTime? = null,

    @Column(name = "title", length = 50, nullable = true)
    var title: String? = null,

    @Column(name = "contents", columnDefinition = "TEXT", nullable = false)
    var contents: String,

    @ManyToOne
    @JoinColumn(name = "weather_id", referencedColumnName = "id")
    val weather: WeatherEntity?,

    @ManyToMany
    @JoinTable(
        name = "diary_tag_link",
        joinColumns = [JoinColumn(name = "diary_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "tag_id", referencedColumnName = "id")]
    )
    val tags: Set<DiaryTagEntity> = mutableSetOf(),

    @ManyToMany
    @JoinTable(
        name = "diary_topic_link",
        joinColumns = [JoinColumn(name = "diary_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "topic_id", referencedColumnName = "id")]
    )
    val topics: Set<DiaryTopicEntity> = mutableSetOf()
) {
    fun toDomain(): Diary {
        return Diary(
            id = id ?: throw IllegalArgumentException("Diary ID cannot be null"),
            profile = profile.toProfile()   ,
            createdAt = createdAt ?: throw IllegalArgumentException("Created at cannot be null"),
            modifiedAt = modifiedAt ?: throw IllegalArgumentException("Modified at cannot be null"),
            title = title,
            contents = contents,
            weather = weather?.toDomain(),
            tags = tags.map { it.toDomain() }.toSet(),
            topics = topics.map { it.toDomain() }.toSet()
        )
    }
}