package boj.sort

import kotlin.math.abs

fun main() {
    val rank = Array(readLine()!!.toInt()) { readLine()!!.toInt() }.sortedArray()
    println(rank.foldIndexed(0L) { index, acc, i -> acc + abs(index + 1 - i) })
}