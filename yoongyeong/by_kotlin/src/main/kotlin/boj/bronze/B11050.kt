package boj.bronze

// 이항 계수 1

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    var answer = 1
    repeat(k) { answer = answer * (n-it) / (it+1)}
    print(answer)
}