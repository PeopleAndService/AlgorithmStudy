package boj.bronze

// 세금

fun main() {
    val n = readLine()!!.toLong()
    println("${(n*0.78).toLong()} ${(n*0.8+n*0.2*0.78).toLong()}")
}