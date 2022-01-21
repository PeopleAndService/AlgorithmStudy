package boj.bronze

import kotlin.math.*

// TV 크기

fun main() {
    val (d, h, w) = readLine()!!.split(" ").map { it.toDouble() }
    val x = sqrt(d * d / (h * h + w * w))
    println("${floor(h*x).toInt()} ${floor(w*x).toInt()}")
}