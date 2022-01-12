package boj.class1

fun main() {
    val (n, x) = readLine()!!.split(' ').map { it.toInt() }
    println(readLine()!!.split(' ').filter { it.toInt() < x }.joinToString(" "))
}