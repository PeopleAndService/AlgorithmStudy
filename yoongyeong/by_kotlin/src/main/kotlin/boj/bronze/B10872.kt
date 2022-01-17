package boj.bronze

// 팩토리얼

fun main() {
    println(factorial(readLine()!!.toInt()))
}

fun factorial(number: Int): Int {
    return if (number in 0..1) 1
    else factorial(number-1) * number
}