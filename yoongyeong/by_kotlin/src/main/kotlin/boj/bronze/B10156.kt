package boj.bronze

// 과자

fun main() {
    val (k, n, m) = readLine()!!.split(" ").map { it.toInt() }
    println(if (k * n - m < 0) 0 else k * n - m)
}