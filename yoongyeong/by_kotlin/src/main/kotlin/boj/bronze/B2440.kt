package boj.bronze

// 별 찍기 - 3

fun main() {
    for (i in readLine()!!.toInt() downTo 1) println("*".repeat(i))
}