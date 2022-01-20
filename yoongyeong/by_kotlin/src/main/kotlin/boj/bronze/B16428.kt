package boj.bronze

// A/B - 3

fun main() {
    val (a, b) = readLine()!!.split(" ").map { it.toBigInteger() }
    val div = a.divide(b)
    val zero = 0.toBigInteger(); val one = 1.toBigInteger()

    if (a < zero && a != zero && b > zero) println("${div-one}\n${a-(b*(div-one))}")
    else if (a < zero && a!= zero && b < zero) println("${div+one}\n${a-(b*(div+one))}")
    else println("$div\n${a.remainder(b)}")
}