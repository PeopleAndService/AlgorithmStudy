package boj.bronze

import kotlin.math.sqrt

// 분수찾기

fun main() {
    val x = readLine()!!.toInt()
    var line = sqrt(2.0 * x).toInt()
    if (line * (line + 1) / 2 < x) line += 1
    val left = x - (line * (line - 1) / 2)
    if (line % 2 == 0) println("$left/${line + 1 - left}")
    else println("${line + 1 - left}/$left")
}