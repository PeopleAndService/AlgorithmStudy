package boj.bronze

// Teleportation

import kotlin.math.*

fun main() {
    val (a, b, x, y) = readLine()!!.split(" ").map { it.toInt() }
    println(min(abs(a-b), min(abs(a-x)+abs(b-y), abs(a-y)+abs(b-x))))
}