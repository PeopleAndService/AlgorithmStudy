package boj.bronze

// 큰 수 (BIG)

fun main() {
    val n = readLine()!!
    var answer = 0
    for (i in n.indices) answer = (answer * 10 + (n[i].toInt() - '0'.toInt())) % 20000303
    println(answer)
}