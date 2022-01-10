package boj.bronze

// 파티가 끝나고 난 뒤

fun main() {
    val (L, P) = readLine()!!.split(" ").map {it.toInt()}
    val (a, b, c, d, e) = readLine()!!.split(" ").map { it.toInt() }
    println("${a-L*P} ${b-L*P} ${c-L*P} ${d-L*P} ${e-L*P}")
}