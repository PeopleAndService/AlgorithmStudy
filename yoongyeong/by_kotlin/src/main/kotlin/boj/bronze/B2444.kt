package boj.bronze

// 별 찍기 - 7

fun main() {
    val n = readLine()!!.toInt()
    for (i in 1 until n) println(" ".repeat(n-i) + "*".repeat(2 * i - 1))
    for (i in n downTo 1) println(" ".repeat(n-i) + "*".repeat(2 * i - 1))
}