package com.zzkun.shorturl.entities

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class UrlDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    var longUrl: String = ""

    var createTime = LocalDateTime.now()
}