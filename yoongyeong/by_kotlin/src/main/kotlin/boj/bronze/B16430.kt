package boj.bronze

// 제리와 톰

fun main() = println(readLine()!!.split(" ").map { it.toInt() }.let { "${it[1]-it[0]} ${it[1]}" })