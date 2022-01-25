package boj.bronze

// Square Pasture

import kotlin.math.*

fun main() {
    val (a, b, c, d) = readLine()!!.split(" ").map { it.toDouble() }
    val (e, f, g, h) = readLine()!!.split(" ").map { it.toDouble() }
    print((max(max(g, c) - min(e, a), max(h, d) - min(f, b))).pow(2).toInt())
}