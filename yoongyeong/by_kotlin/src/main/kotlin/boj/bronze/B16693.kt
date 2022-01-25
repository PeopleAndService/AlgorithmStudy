package boj.bronze

import kotlin.math.PI

// Pizza Deal

fun main() {
    val a = readLine()!!.split(" ").map { it.toDouble() }.let { (a, b) -> a/b }
    val b = readLine()!!.split(" ").map { it.toDouble() }.let { (a, b) -> a*a* PI/b }
    print(if (a>b) "Slice of pizza" else "Whole pizza")
}