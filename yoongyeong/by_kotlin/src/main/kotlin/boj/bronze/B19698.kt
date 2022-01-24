package boj.bronze

// 헛간 청약

fun main() {
    val (n, w, h, l) = readLine()!!.split(" ").map { it.toInt() }
    ((w/l)*(h/l)).run { print(if(this > n) n else this)}
}