package boj.bronze

// 帰省 (Homecoming)

fun main() = print(readLine()!!.split(" ").map { it.toInt() }.let { (a,b,c)-> if(c in a until b) 1 else 0 })