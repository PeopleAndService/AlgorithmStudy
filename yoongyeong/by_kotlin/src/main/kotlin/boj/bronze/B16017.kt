package boj.bronze

// Telemarketer or not?

fun main() {
    val (a, b, c, d) = List(4) {readLine()!!.toInt() }
    print(if (a in 8..9 && d in 8..9 && b==c) "ignore" else "answer")
}