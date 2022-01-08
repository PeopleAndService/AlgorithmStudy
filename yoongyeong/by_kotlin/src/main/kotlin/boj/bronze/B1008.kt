package boj.bronze

// A/B

fun main() {
    val (a, b) = readLine()!!.split(' ').map { it.toDouble() }
    println(a / b)
}