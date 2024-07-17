package com.conymind.backend.model.api

data class UpdateTaskRequest(
    val content: String,
    val completed: Boolean
)