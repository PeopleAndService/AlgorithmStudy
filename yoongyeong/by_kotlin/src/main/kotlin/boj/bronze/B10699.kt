package boj.bronze

import java.time.*

// 오늘 날짜

fun main() = println(ZonedDateTime.now(ZoneId.of("Asia/Seoul")).toString().substring(0, 10))