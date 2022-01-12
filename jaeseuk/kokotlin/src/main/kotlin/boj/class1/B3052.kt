package boj.class1

fun main() {
    println(IntArray(10) { readLine()!!.toInt() % 42 }.distinct().size)
}