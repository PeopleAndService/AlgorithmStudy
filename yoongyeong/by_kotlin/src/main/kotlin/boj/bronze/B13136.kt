package boj.bronze

import kotlin.math.ceil

// Do Not Touch Anything

fun main() {
    val (r, c, n) = readLine()!!.split(" ").map { it.toDouble() }
    println((ceil(r/n) * ceil(c/n)).toLong())
}