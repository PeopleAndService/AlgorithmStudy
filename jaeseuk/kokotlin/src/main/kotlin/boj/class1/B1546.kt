package boj.class1

fun main() {
    val n = readLine()!!.toInt()
    val scores = readLine()!!.split(' ').map { it.toDouble() }
    val m = scores.maxOrNull()!!

    println(scores.map { it / m * 100 }.average())
}