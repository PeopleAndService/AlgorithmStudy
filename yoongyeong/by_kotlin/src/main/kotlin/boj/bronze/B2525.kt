package boj.bronze

// 오븐 시계

fun main() {
    var (h, m) = readLine()!!.split(" ").map { it.toInt() }
    m += readLine()!!.toInt()
    if (m > 59) h += m / 60; m %= 60
    if (h > 23) h %= 24
    println("$h $m")
}