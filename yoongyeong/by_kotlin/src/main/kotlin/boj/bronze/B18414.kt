package boj.bronze

import kotlin.math.abs

// X に最も近い値 (The Nearest Value)

fun main() {
    val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
    var (temp, ans) = 100000 to 0
    for (i in b..c) {
        if (abs(a-i)<temp) {
            temp = abs(a - i)
            ans = i
        }
    }
    print(ans)
}