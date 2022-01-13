package boj.silver

// 한수

fun main() {
    var n = readLine()!!.toInt()
    if (n < 100) println(n)
    else {
        var cnt = 0
        if (n == 1000) n -= 1
        for (i in 111..n) if (((i / 100 % 10) + (i % 10)) == 2 * (i / 10 % 10)) cnt += 1
        println(99+cnt)
    }
}