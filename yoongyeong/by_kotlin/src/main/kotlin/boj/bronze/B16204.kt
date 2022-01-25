package boj.bronze

// 카드 뽑기

fun main() {
    val (n, m, k) = readLine()!!.split(" ").map { it.toInt() }
    print(minOf(m, k)+ minOf(n-m, n-k))
}