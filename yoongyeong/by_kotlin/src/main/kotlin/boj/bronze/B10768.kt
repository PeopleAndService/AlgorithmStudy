package boj.bronze

// 특별한 날

fun main() {
    val (m, d) = List(2) { readLine()!!.toInt()}
    println(when {
        m < 2 || (m == 2 && d < 18)-> "Before"
        m == 2 && d == 18 -> "Special"
        else -> "After"
    })
}