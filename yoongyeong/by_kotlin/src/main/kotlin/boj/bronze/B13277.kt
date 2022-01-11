package boj.bronze

// 큰 수 곱셈

fun main() = println(readLine()!!.split(" ").map { it.toBigInteger() }.let { it[0] * it[1] })