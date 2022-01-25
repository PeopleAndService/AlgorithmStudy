package boj.bronze

import kotlin.math.hypot

// Cutting Corners

fun main() {
    val (a, b) = readLine()!!.split(" ").map { it.toDouble() }
    print("%.9f".format(a+b- hypot(a, b)))
}