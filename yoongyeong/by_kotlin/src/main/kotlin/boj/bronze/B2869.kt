package boj.bronze

import kotlin.math.ceil

// 달팽이는 올라가고 싶다

fun main() {
    val (A, B, V) = readLine()!!.split(" ").map { it.toDouble() }
    println(ceil((V-B)/(A-B)).toInt())
}