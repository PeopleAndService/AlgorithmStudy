package boj.bronze

// 꼬마 정민

fun main() = println(readLine()!!.split(" ").map { it.toBigInteger() }.let { it[0] + it[1] + it[2] })