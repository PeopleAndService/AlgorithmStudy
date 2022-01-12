package boj.bronze

// 스타후르츠

fun main() {
    val (N, T, C, P) = readLine()!!.split(" ").map { it.toLong() }
    println((N-1)/T*C*P)
}