package boj.bronze

// Bank Transfer

fun main() {
    var answer = (readLine()!!.toDouble()) * 0.01 + 25
    if (answer > 2000) answer = 2000.0
    if (answer < 100) answer = 100.0
    print("%.2f".format(answer))
}