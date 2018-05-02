package com.zzkun.shorturl.entities

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class UrlDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @Column(length = 10240)
    var longUrl: String = ""

    var createTime = LocalDateTime.now()
}