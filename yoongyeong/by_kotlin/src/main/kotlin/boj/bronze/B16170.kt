package boj.bronze

import java.time.*

// 오늘의 날짜는?

fun main() = println(ZonedDateTime.now(ZoneId.of("UTC")).toString().let { "${it.slice(0..3)}\n${it.slice(5..6)}\n${it.slice(8..9)}"})