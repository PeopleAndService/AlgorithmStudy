package boj.bronze

// Bałwanek

fun main() {
    val (a, b) = readLine()!!.split(" ").map { it.toLong() }
    print(when  {
        7000*b <= a*1000 -> 7000*b
        3500*b <= a*1000 -> 3500*b
        1750*b <= a*1000 -> 1750*b
        else -> 0
    })
}