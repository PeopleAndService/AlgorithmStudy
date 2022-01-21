package boj.bronze

import kotlin.math.*

// AFC 윔블던

fun main() {
    val (p, m) = readLine()!!.split(" ").map {it.toInt()}
    if (p-m<0 || (p-m)%2 !=0) println(-1)
    else {
        val a = (p+m)/2; val b = p-a
        println("${max(a, b)} ${min(a, b)}")
    }
}