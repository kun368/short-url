package com.zzkun.shorturl.controller

import com.zzkun.shorturl.service.ShortUrlService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletResponse

@Controller
class RedirectController(@Autowired private val shortUrlService: ShortUrlService) {

    private val logger = LoggerFactory.getLogger(RedirectController::class.java)

    @RequestMapping("/{name}")
    fun redirect(@PathVariable("name") name: String, resp: HttpServletResponse) {
        try {
            val result = shortUrlService.shortToLong(name)
            if (result == null) {
                resp.sendError(404)
            } else {
                resp.sendRedirect(result)
            }
        } catch (e: Exception) {
            logger.error("RedirectController error", e)
            resp.sendError(503)
        }
    }
}