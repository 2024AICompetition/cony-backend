package com.conymind.backend.model

data class ApiResponse<T>(
    val success: Boolean,
    val data: T?,
    val message: String?
)