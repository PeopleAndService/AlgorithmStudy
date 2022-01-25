package boj.bronze

// Checkers

fun main() {
    val (a, b) = readLine()!!.split(" ").map { it.toLong() }
    print(if(a<=b-1)a+1 else b)
}