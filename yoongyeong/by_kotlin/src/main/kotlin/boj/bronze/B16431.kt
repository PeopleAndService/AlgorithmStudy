package boj.bronze


// 베시와 데이지

import kotlin.math.*

fun main() {
    val (b1, b2) = readLine()!!.split(" ").map { it.toInt() }
    val (d1, d2) = readLine()!!.split(" ").map { it.toInt() }
    val (j1, j2) = readLine()!!.split(" ").map { it.toInt() }
    val (bessie, daisy) = (max(abs(b1-j1), abs(b2-j2))) to (abs(d1-j1)+abs(d2-j2))
    print(if (bessie < daisy) "bessie" else if(bessie==daisy) "tie" else "daisy")
}