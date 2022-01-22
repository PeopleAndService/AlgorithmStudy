package boj.bronze

// 쿠폰

fun main() {
    repeat(readLine()!!.toInt()) {
        println("$%.2f".format(readLine()!!.toDouble() * 0.8))
    }
}