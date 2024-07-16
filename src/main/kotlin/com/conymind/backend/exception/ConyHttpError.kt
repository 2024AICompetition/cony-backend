package com.conymind.backend.exception

import com.conymind.backend.model.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

enum class ConyHttpError(val httpStatus: HttpStatus, val code: String, val message: String) {
    // Bad request
    INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "INVALID_PARAMETER", "잘못된 파라미터"),

    // Internal server error
    UNEXPECTED_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "UNEXPECTED_ERROR", "예상치 못한 에러"),

    // Not Found
    ENTITY_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "ENTITY_NOT_FOUND_EXCEPTION", "요청한 데이터를 찾을 수 없습니다"),
}

