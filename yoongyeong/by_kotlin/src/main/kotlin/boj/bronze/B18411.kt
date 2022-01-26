package boj.bronze

// 試験 (Exam)

fun main() {
    val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
    print(a+b+c- minOf(a, minOf(b, c)))
}