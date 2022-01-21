package boj.bronze

import kotlin.math.abs

// 사파리월드

fun main() = println(readLine()!!.split(" ").map { it.toLong() }.let { abs(it[0]-it[1]) })