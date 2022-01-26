package boj.bronze

// 별 찍기 - 8

fun main() {
    val n = readLine()!!.toInt()
    for (i in 1 until n) println("*".repeat(i) + " ".repeat(2*(n-i)) + "*".repeat(i))
    for (i in n downTo 1) println("*".repeat(i) + " ".repeat(2*(n-i)) + "*".repeat(i))
}