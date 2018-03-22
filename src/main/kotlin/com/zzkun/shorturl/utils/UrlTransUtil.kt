package com.zzkun.shorturl.utils

object UrlTransUtil {

    private const val TOTAL_COUNT = 10 + 26 + 26;

    fun toDecimal(x: String): Long {
        var res = 0L
        x.forEach {
            when {
                it.isDigit() -> res = (res * TOTAL_COUNT) + (it - '0')
                it.isLowerCase() -> res = (res * TOTAL_COUNT) + (it - 'a' + 10)
                it.isUpperCase() -> res = (res * TOTAL_COUNT) + (it - 'A' + 10 + 26)
            }
        }
        return res
    }

    fun toMixing(x: Long): String {
        if (x == 0L) {
            return "0"
        }
        var left = x
        return buildString {
            while (left > 0) {
                val cur = (left % TOTAL_COUNT).toInt()
                when {
                    cur < 10 -> append(cur)
                    cur < 10 + 26 -> append('a' + (cur - 10))
                    else -> append('A' + (cur - 10 - 26))
                }
                left /= TOTAL_COUNT
            }
        }.reversed()
    }
}


fun main(args: Array<String>) {
    for (x in 0L..1200) {
        println("$x -> ${UrlTransUtil.toMixing(x)} -> ${UrlTransUtil.toDecimal(UrlTransUtil.toMixing(x))}")
    }
    println(UrlTransUtil.toDecimal("2"))
    println(UrlTransUtil.toDecimal("b"))
    println(UrlTransUtil.toDecimal("B"))
    println(UrlTransUtil.toDecimal("b1"))
}