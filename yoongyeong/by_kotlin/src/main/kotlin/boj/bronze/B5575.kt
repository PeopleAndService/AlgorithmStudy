package boj.bronze

// 타임 카드

fun main() {
    repeat(3) {
        val p = readLine()!!.split(" ").map { it.toInt() }
        var h = p[3]-p[0]; var m = p[4]-p[1]; var s = p[5]-p[2]
        if (s < 0) {s+=60; m -= 1}
        if (m < 0) {m+=60; h -= 1}
        println("$h $m $s")
    }
}