package com.conymind.backend.exception

open class ConyRuntimeException(message: String? = null, val conyHttpError: ConyHttpError) :
    RuntimeException(message ?: conyHttpError.message)

