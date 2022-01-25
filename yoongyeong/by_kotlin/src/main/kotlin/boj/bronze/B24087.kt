package boj.bronze

// アイスクリーム (Ice Cream)

fun main() {
    val (s, a, b) = List(3) {readLine()!!.toDouble()}
    if (a >= s) print(250)
    else print(250 + kotlin.math.ceil((s - a) / b).toInt() * 100)
}