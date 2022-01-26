package boj.bronze

// 별 찍기 -6

fun main() {
    val n = readLine()!!.toInt()
    for (i in n downTo 1) println(" ".repeat(n-i) + "*".repeat(2 * i - 1))
}