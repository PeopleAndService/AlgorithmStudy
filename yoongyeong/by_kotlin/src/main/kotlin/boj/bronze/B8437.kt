package boj.bronze

// Julka

fun main() {
    val (a, b) = List(2) { readLine()!!.toBigInteger()}
    println("${(a+b)/2.toBigInteger()}\n${(a-b)/2.toBigInteger()}")
}