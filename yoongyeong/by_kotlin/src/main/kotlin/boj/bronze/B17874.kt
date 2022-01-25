package boj.bronze

// Piece of Cake!

fun main() = print(readLine()!!.split(" ").map { it.toInt() }.let { (a, b, c) -> 4* maxOf(a-c, c)* maxOf(a-b, b) })