package com.conymind.backend.config.advice

import com.conymind.backend.exception.ConyRuntimeException
import com.conymind.backend.model.ApiResponse
import org.apache.coyote.BadRequestException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ConyRuntimeException::class)
    fun handleConyRuntimeException(ex: ConyRuntimeException, request: WebRequest): ResponseEntity<ApiResponse<Nothing>> {
        val apiResponse = ApiResponse(
            success = false,
            data = null,
            message = ex.message
        )
        return ResponseEntity(apiResponse, ex.conyHttpError.httpStatus)
    }

    @ExceptionHandler(Exception::class)
    fun handleGlobalException(ex: Exception, request: WebRequest): ResponseEntity<ApiResponse<Nothing>> {
        val apiResponse = ApiResponse(
            success = false,
            data = null,
            message = "An unexpected error occurred: ${ex.message}"
        )
        return ResponseEntity(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(BadRequestException::class, MissingServletRequestParameterException::class)
    fun handleBadRequestException(ex: BadRequestException, request: WebRequest): ResponseEntity<ApiResponse<Nothing>> {
        val apiResponse = ApiResponse(
            success = false,
            data = null,
            message = "${ex.message}"
        )

        return ResponseEntity(apiResponse, HttpStatus.BAD_REQUEST)
    }
}