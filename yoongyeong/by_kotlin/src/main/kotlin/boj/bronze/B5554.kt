package boj.bronze

// 심부름 가는 길

fun main() {
    var sum = 0
    for (i in 1..4) sum += readLine()!!.toInt()
    println("${sum/60}\n${sum%60}")
}