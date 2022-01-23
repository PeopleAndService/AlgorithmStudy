package boj.bronze

// SASA 모형을 만들어보자

fun main() = print(readLine()!!.split(" ").minOf { it.toInt() }/2)