package boj.bronze

// A + B -9

fun main() {
    val (a, b) = readLine()!!.split(" ").map { it.toBigInteger() }
    println(a + b)
}