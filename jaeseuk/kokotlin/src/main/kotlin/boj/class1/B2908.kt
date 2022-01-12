package boj.class1

fun main() {
    val (a, b) = readLine()!!.split(' ')
    println(maxOf(a.reversed(), b.reversed()))
}