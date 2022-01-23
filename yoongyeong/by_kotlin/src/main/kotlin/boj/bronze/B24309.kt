package boj.bronze

// РАВЕНСТВО

fun main() {
    val (a, b, c) = List(3) { readLine()!!.toBigInteger()}
    print((b-c)/a)
}