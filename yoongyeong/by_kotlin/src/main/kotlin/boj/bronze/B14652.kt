package boj.bronze

// 나는 행복합니다~

fun main() = println(readLine()!!.split(" ").map { it.toInt() }.let { "${it[2]/it[1]} ${it[2]%it[1]}" })