package com.zzkun.shorturl.dao

import com.zzkun.shorturl.entities.UrlDO
import org.springframework.data.repository.CrudRepository

interface UrlRepo : CrudRepository<UrlDO, Long> {
    fun findByLongUrl(longUrl: String): UrlDO?
}