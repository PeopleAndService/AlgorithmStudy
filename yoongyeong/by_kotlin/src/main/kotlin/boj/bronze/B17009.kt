package boj.bronze

// Winning Score

fun main() {
    val (a, b, c) = List(3) { readLine()!!.toLong()}
    val (d, e, f) = List(3) { readLine()!!.toLong()}
    when {
        a*3+b*2+c == d*3+e*2+f -> print("T")
        a*3+b*2+c > d*3+e*2+f -> print("A")
        else -> print("B")
    }
}