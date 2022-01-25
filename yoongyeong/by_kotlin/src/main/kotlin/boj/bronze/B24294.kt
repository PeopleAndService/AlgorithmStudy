package boj.bronze

// ГРАДИНА

fun main() {
    val (w1, h1, w2, h2) = List(4) { readLine()!!.toLong()}
    if (w1 < w2) print(2 * (h1+h2+w2+2))
    else print(2 * (h1+h2+w1+2))
}