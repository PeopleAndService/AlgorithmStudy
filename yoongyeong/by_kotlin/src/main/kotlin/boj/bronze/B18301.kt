package boj.bronze

import kotlin.math.floor

// Rats

fun main() {
    val (n1, n2, n12) = readLine()!!.split(" ").map { it.toInt() }
    println(floor((n1+1)*(n2+1)/(n12+1)-1.0).toInt())
}