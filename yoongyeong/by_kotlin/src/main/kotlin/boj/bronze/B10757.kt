package boj.bronze

// 큰 수 A+B

fun main() {
    val (A, B) = readLine()!!.split(" ").map { it.toBigInteger() }
    println(A+B)
}