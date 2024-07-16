package com.conymind.backend.config.advice

import com.conymind.backend.controller.ImageController
import com.conymind.backend.model.ApiResponse
import org.springframework.core.MethodParameter
import org.springframework.core.io.Resource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice
import java.lang.reflect.ParameterizedType

@RestControllerAdvice
class ApiResponseAdvice : ResponseBodyAdvice<Any> {

    override fun supports(returnType: MethodParameter, converterType: Class<out HttpMessageConverter<*>>): Boolean {
        if (returnType.parameterType == ResponseEntity::class.java) {
            val genericType = returnType.getGenericParameterType()
            if (genericType is ParameterizedType) {
                val typeArguments = genericType.actualTypeArguments
                if (typeArguments.isNotEmpty() && typeArguments[0] == Resource::class.java) {
                    return false
                }
            }
        }

        return true
    }

    override fun beforeBodyWrite(
        body: Any?,
        returnType: MethodParameter,
        selectedContentType: MediaType,
        selectedConverterType: Class<out HttpMessageConverter<*>>,
        request: ServerHttpRequest,
        response: ServerHttpResponse
    ): Any? {
        return when (body) {
            is ApiResponse<*> -> body
            null -> ApiResponse(success = true, data = null, message = null)
            else -> ApiResponse(success = true, data = body, message = null)
        }
    }
}