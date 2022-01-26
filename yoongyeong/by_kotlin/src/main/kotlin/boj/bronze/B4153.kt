package boj.bronze

// 직각삼각형

fun main() {
    var numbers = readLine()!!.split(" ").map { it.toDouble() }.sorted()
    while (numbers.sum()!=0.0) {
        println(if (kotlin.math.hypot(numbers[0], numbers[1]) == numbers[2]) "right" else "wrong")
        numbers = readLine()!!.split(" ").map { it.toDouble() }.sorted()
    }
}