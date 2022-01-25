package boj.bronze

// 計算 (Calculation)

fun main() = print(readLine()!!.split(" ").map { it.toInt() }.let { (a, b) ->"${maxOf(a+b, a-b)}\n${minOf(a+b, a-b)}" })