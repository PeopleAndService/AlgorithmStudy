package boj.bronze

// ISBN

fun main() {
    val (a, b, c) = List(3) { readLine()!!.toInt()}
    println("The 1-3-sum is ${91+a+b*3+c}")
}