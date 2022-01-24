package boj.bronze

// Hard choice

fun main() {
    val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
    val (d, e, f) = readLine()!!.split(" ").map { it.toInt() }
    var answer = 0
    if (d > a) answer += d - a
    if (e > b) answer += e - b
    if (f > c) answer += f - c
    print(answer)
}