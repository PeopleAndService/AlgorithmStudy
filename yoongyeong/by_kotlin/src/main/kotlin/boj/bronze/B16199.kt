package boj.bronze

// 나이 계산하기

fun main() {
    val (y, m, d) = readLine()!!.split(" ").map { it.toInt() }
    val (yy, mm, dd) = readLine()!!.split(" ").map { it.toInt() }

    println(if(mm>m || (mm==m && dd>=d)) (yy-y) else (yy-y-1))
    println(yy-y+1)
    println(yy-y)
}