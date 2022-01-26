package boj.bronze

// 세 수

fun main() = print(readLine()!!.split(" ").map { it.toInt() }.sorted()[1])