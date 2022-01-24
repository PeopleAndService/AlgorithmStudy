package boj.bronze

// Tri-du

fun main() = print(readLine()!!.split(" ").maxOf { it.toInt() })
