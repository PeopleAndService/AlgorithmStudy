package boj.bronze

// 삼각형 외우기

fun main() {
    val (a, b, c) = List(3) { readLine()!!.toInt()}
    when {
        (a+b+c) != 180 -> println("Error")
        (a==b) && (b==c) -> println("Equilateral")
        (a==b) || (b==c) || (a==c) -> println("Isosceles")
        else -> println("Scalene")
    }
}