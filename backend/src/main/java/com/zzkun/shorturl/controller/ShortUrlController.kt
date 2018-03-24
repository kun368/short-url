package com.zzkun.shorturl.controller

import com.zzkun.shorturl.entities.Result
import com.zzkun.shorturl.service.ShortUrlService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/url/")
class ShortUrlController(@Autowired private val shortUrlService: ShortUrlService) {

    private val logger = LoggerFactory.getLogger(ShortUrlController::class.java)

    @RequestMapping("/shortToLong")
    fun shortToLong(@RequestParam url: String): Any {
        return try {
            val result = shortUrlService.shortToLong(url)
            if (result != null) Result(true, result) else Result(false, "未找到对应的网址~")
        } catch (e: Exception) {
            logger.error("shortToLong error", e)
            Result(false, e.message)
        }
    }

    @RequestMapping("/longToShort")
    fun longToShort(@RequestParam url: String): Any {
        return try {
            Result(true, shortUrlService.longToShort(url))
        } catch (e: Exception) {
            logger.error("longToShort error", e)
            Result(false, e.message)
        }
    }
}