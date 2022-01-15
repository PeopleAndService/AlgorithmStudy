package boj.bronze

// 세수정렬

fun main() = println(readLine()!!.split(" ").map { it.toInt() }.sorted().let { "${it[0]} ${it[1]} ${it[2]}" })
