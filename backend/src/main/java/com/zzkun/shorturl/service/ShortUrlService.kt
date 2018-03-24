package com.zzkun.shorturl.service

import com.zzkun.shorturl.dao.UrlRepo
import com.zzkun.shorturl.entities.UrlDO
import com.zzkun.shorturl.utils.UrlTransUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShortUrlService(@Autowired val urlRepo: UrlRepo) {

    fun shortToLong(short: String): String? {
        val id = UrlTransUtil.toDecimal(short)
        val findById = urlRepo.findById(id)
        return if (findById.isPresent) findById.get().longUrl else null
    }

    fun longToShort(long: String): String {
        val prev = urlRepo.findByLongUrl(long)
        if (prev == null) {
            var urlDO = UrlDO()
            urlDO.longUrl = long
            urlDO = urlRepo.save(urlDO)
            return UrlTransUtil.toMixing(urlDO.id)
        }
        return UrlTransUtil.toMixing(prev.id)
    }
}