package boj.bronze

import kotlin.math.pow

// 이상한 기호

fun main() = println(readLine()!!.split(" ").map { it.toDouble() }.let {( it[0].pow(2)-it[1].pow(2) ).toLong()})