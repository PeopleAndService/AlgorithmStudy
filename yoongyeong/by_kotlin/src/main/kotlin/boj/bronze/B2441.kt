package boj.bronze

// 별 찍기 -4

fun main() {
    val n = readLine()!!.toInt()
    for (i in n downTo 1) println(" ".repeat(n-i) + "*".repeat(i))
}