package boj.bronze

// 金平糖 (Konpeito)

fun main() {
    val numbers = readLine()!!.split(" ").map { it.toInt() }
    print((3 * numbers.maxOrNull()!!).minus(numbers.sum()))
}