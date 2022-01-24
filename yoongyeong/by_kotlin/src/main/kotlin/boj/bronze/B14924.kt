package boj.bronze

// 폰 노이만과 파리

fun main() = println(readLine()!!.split(" ").map { it.toInt() }.let { it[2]/it[0]/2*it[1] })