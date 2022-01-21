package boj.bronze

import kotlin.math.min

// 상근날드

fun main() {
    var burger = min(readLine()!!.toInt(), readLine()!!.toInt())
    burger = min(readLine()!!.toInt(), burger)
    val juice = min(readLine()!!.toInt(), readLine()!!.toInt())
    println(burger+juice-50)
}