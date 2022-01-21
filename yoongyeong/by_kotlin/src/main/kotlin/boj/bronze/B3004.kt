package boj.bronze

// 체스판 조각

fun main() {
    val n = readLine()!!.toInt()
    println(if(n%2 ==0) (n/2+1) * (n/2+1) else (n/2+1) * (n/2+2))
}