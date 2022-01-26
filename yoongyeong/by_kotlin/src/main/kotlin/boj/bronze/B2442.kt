package boj.bronze

// 별 찍기 - 5

fun main() {
    val n = readLine()!!.toInt()
    for (i in 1..n) println(" ".repeat(n-i) + "*".repeat(2 * i - 1))
}