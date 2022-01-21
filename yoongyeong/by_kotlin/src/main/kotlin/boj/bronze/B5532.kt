package boj.bronze

import kotlin.math.*

// 방학 숙제

fun main() {
    val l = readLine()!!.toInt()
    val a = readLine()!!.toDouble(); val b = readLine()!!.toDouble()
    val c = readLine()!!.toDouble(); val d = readLine()!!.toDouble()
    println(l-max(ceil(a/c), ceil(b/d)).toInt())
}