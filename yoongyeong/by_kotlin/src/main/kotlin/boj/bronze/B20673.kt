package boj.bronze

// Covid-19

fun main() {
    val (n, m) = readLine()!!.toInt() to readLine()!!.toInt()
    print(when {
        n <= 50 && m <= 10 -> "White"
        m > 30 -> "Red"
        else -> "Yellow"
    })
}