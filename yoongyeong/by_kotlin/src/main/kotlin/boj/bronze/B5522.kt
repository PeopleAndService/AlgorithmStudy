package boj.bronze

// 카드 게임

fun main() {
    var sum = 0
    for (i in 1..5) sum += readLine()!!.toInt()
    println(sum)
}