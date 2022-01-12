package boj.class1

fun main() {
    println(when(readLine()!!.split(' ').map { it.toInt() }) {
        (1..8).toList() -> "ascending"
        (8 downTo 1).toList() -> "descending"
        else -> "mixed"
    })
}