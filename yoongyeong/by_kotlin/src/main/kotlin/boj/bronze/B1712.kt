package boj.bronze

// 손익분기점

fun main() {
    val (a, b, c) = readLine()!!.split(" ").map { it.toBigInteger() }
    if (b >= c) println(-1)
    else println( a / (c - b) + 1.toBigInteger())
}