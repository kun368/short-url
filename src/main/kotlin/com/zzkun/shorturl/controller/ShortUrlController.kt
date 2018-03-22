package com.zzkun.shorturl.controller

import com.zzkun.shorturl.service.ShortUrlService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ShortUrlController(@Autowired private val shortUrlService: ShortUrlService) {

    @RequestMapping("/shortToLong/{url}")
    fun shortToLong(@RequestParam("url") url: String): Any {
        return shortUrlService.shortToLong(url)
    }

    @RequestMapping("/longToShort/{url}")
    fun longToShort(@RequestParam("url") url: String): Any {
        return shortUrlService.longToShort(url)
    }
}