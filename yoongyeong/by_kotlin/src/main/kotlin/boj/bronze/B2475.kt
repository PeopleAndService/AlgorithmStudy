package boj.bronze

import kotlin.math.pow

// 검증수

fun main() =  print((readLine()!!.split(" ").map{(it.toDouble()).pow(2)}.sum() % 10).toInt())