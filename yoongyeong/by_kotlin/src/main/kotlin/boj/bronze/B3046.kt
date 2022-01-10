package boj.bronze

// R2

fun main() {
    val (R1, S) = readLine()!!.split(" ").map { it.toInt() }
    println(S*2-R1)
}