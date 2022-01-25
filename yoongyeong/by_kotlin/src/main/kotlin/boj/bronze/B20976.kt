package boj.bronze

// 2 番目に大きい整数 (The Second Largest Integer)

fun main() = print(readLine()!!.split(" ").map { it.toInt() }.sorted()[1])
