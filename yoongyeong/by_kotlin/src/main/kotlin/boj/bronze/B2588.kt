package boj.bronze

// 곱셈

fun main() {
    val num1 = readLine()!!
    val num2 = readLine()!!
    println(num1.toInt()*(num2.toInt()%10))
    println(num1.toInt()*(num2.toInt()%100/10))
    println(num1.toInt()*(num2.toInt()/100))
    println(num1.toInt()*num2.toInt())
}