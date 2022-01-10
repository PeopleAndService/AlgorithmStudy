package boj.bronze

// 엄청난 부자2

fun main(){
    val (n, m) = readLine()!!.split(" ").map { it.toBigInteger() }
    println("${n/m}")
    println("${n%m}")
}