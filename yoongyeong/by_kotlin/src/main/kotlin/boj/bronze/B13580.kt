package boj.bronze

// Andando no tempo

fun main() {
    val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
    print(if (a==b||a==c||b==c||a+b==c||a+c==b||b+c==a) "S" else "N")
}