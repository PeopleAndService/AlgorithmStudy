package boj.bronze

// 뉴비의 기준은 뭘까?

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    print(when(m) {
        in 1..2 -> "NEWBIE!"
        in 3..n -> "OLDBIE!"
        else -> "TLE!"
    })
}