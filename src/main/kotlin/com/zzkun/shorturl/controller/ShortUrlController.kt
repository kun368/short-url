package com.zzkun.shorturl.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/")
class ShortUrlController {

    @RequestMapping("/")
    fun hello(): Any {
        return arrayOf("1", "2")
    }

}