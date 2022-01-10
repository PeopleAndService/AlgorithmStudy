package boj.bronze

// 나머지

fun main() {
    val (A, B, C) = readLine()!!.split(" ").map { it.toInt() }
    println("${(A+B)%C}\n${((A%C) + (B%C))%C}\n${(A*B)%C}\n${((A%C)*(B%C))%C}")
}