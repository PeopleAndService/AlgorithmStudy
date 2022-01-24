package boj.bronze

// 이칙연산

fun main() = print(readLine()!!.split(" ").map {it.toLong()}.let {it[0]* maxOf(it[1],it[2])/minOf(it[1],it[2]) })