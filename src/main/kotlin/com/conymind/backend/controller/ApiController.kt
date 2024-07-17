package com.conymind.backend.controller

import com.conymind.backend.model.Quote
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class ApiController {

    @GetMapping("/getDailyQuote")
    fun getDailyQuote(): Quote {
        return Quote(
            "직장 상사와 갈등이 있어도 너무 걱정하지 마세요!",
        )
    }
}