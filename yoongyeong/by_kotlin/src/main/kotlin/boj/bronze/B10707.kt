package boj.bronze

// 수도요금

fun main() {
    val (a, b, c, d, p) = List(5) { readLine()!!.toInt()}
    val y = if (p < c) b else b + (p-c) * d
    println(minOf(a * p , y))
}