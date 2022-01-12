package boj.bronze

// Site Score

fun main() = println(readLine()!!.split(" ").map { it.toInt() }.let { it[0]*56+it[1]*24+it[2]*14+it[3]*6})