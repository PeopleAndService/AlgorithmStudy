package boj.class1

fun main() {
    val numbers = IntArray(10) { 0 }
    val mul = IntArray(3) { readLine()!!.toInt() }.reduce { acc, i -> acc * i }.toString()

    for (ch in mul) {
        numbers[ch - '0'] += 1
    }

    numbers.forEach { println(it) }
}