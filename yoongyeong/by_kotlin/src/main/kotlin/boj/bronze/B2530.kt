package boj.bronze

// 인공지능 시계

fun main() {
    var (h, m, s) = readLine()!!.split(" ").map { it.toInt() }
    s += readLine()!!.toInt()
    if (s > 59) m += s / 60; s %= 60
    if (m > 59) h += m / 60; m %= 60
    if (h > 23) h %= 24
    println("$h $m $s")
}