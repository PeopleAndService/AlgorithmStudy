package boj.bronze

// Volta

import kotlin.math.*

fun main() {
    val (a, b) = readLine()!!.split(" ").map { it.toDouble() }
    print(ceil(1 / abs(1 / a - 1 / b) * 1 / min(a, b)).toInt())
}