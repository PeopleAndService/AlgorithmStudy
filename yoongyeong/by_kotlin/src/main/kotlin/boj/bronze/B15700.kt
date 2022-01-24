package boj.bronze

// 타일 채우기 4

fun main() = println(readLine()!!.split(" ").map { it.toLong() }.let { it[0] * it[1] / 2 })