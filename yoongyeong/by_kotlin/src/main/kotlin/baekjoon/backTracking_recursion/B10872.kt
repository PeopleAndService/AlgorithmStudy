package baekjoon.backTracking_recursion

// 팩토리얼

fun main() {
    println(factorial(readLine()!!.toInt()))
}

private fun factorial(number: Int): Int {
    return if (number in 0..1) 1
    else factorial(number-1) * number
}

private fun dpFactorial(number: Int): Int {
    val array = IntArray(number+1){1}

    for (i in 1..number) array[i] = array[i-1] * i

    return array[number]
}