package boj.bronze

// 사분면 고르기

fun main() {
    val x = readLine()!!.toInt()
    val y = readLine()!!.toInt()
    if (x > 0) {
        if (y > 0) println(1)
        else println(4)
    } else {
        if (y > 0) println(2)
        else println(3)
    }
}