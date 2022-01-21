package boj.bronze

import kotlin.math.max

// 시험 점수

fun main() = println(max(readLine()!!.split(" ").map {it.toInt()}.sum(), readLine()!!.split(" ").map {it.toInt()}.sum()))

fun main2()=print(List(2){readLine()!!.split(' ').sumOf{it.toInt()}}.maxOf{it})