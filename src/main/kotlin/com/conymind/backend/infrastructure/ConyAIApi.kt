package com.conymind.backend.infrastructure

import com.conymind.backend.model.infrastructure.DiaryWithSuggestions
import com.conymind.backend.model.infrastructure.Questions
import com.conymind.backend.model.infrastructure.Tags
import com.conymind.backend.model.infrastructure.Topics
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.RestTemplate
import org.springframework.http.*
import java.awt.Image

class ConyAIApi(
    val basePath: String = "http://127.0.0.1:2000"
) {
    private inline fun <reified T> post(path: String, body: Map<String, String>): T? {
        val factory = HttpComponentsClientHttpRequestFactory()
        val restTemplate = RestTemplate(factory)
        val header = HttpHeaders()

        val entity = HttpEntity<Map<String, String>>(body, header)
        val url = "$basePath/$path"
        val resultMap: ResponseEntity<T> =
            restTemplate.exchange(url, HttpMethod.POST, entity, T::class.java)
        return resultMap.body
    }

    // http://127.0.0.1:2000/v1/diaries/tags
    fun createTags(content: String) {
        post<Tags>("v1/diaries/tags", mapOf("content" to content))
    }

    // http://127.0.0.1:2000/v1/diaries/suggested-topics
    fun createSuggestedTopics(content: String) {
        post<DiaryWithSuggestions>("v1/diaries/tags", mapOf("content" to content))
    }

    // http://127.0.0.1:2000/v1/diaries/diary-content-topics
    fun createDiaryContentTopics(content: String, previousContent: List<String>) {
        post<Topics>("v1/diaries/tags",mapOf("content" to content, "previous_content" to previousContent.toString()))
    }

    // http://127.0.0.1:2000/v1/diaries/embeddings
    fun createEmbedding(content: String) {
        post<List<Double>>("v1/diaries/tags", mapOf("content" to content))
    }

    // http://127.0.0.1:2000/v1/diaries/questions
    fun createQuestion(userInformation: List<String>) {
        post<Questions>("v1/diaries/tags", mapOf("user_information" to userInformation.toString()))
    }

    // http://127.0.0.1:2000/v1/diaries/images
    fun createImage(content: String) {
        post<Image>("v1/diaries/tags", mapOf("content" to content))
    }
}