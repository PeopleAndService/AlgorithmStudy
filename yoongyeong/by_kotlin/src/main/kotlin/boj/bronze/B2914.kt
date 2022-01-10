package boj.bronze

// 저작권

fun main() {
    val (A, I) = readLine()!!.split(" ").map { it.toInt() }
    println(A*(I-1)+1)
}