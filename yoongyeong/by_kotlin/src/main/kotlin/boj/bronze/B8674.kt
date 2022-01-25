package boj.bronze

// Tabliczka

fun main() {
    val (a, b) = readLine()!!.split(" ").map { it.toLong() }
    print(if(a%2==0L||b%2==0L) 0 else minOf(a, b))
}