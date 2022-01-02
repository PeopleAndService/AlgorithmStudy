package programmers

import kotlin.math.abs

fun main(args:Array<String>):Unit{
    println(solution01(-1, -3))
    println(solution01x01(1, 4))
}

// 두 정수 사이의 합
fun solution01(a: Int, b: Int): Long {
    var answer: Long = 0
    if(a < b) {
        for (i in a..b) answer += i
    } else {
        for (i in b..a) answer += i
    }
    return answer
}

fun solution01x01(a: Int, b: Int): Long =
    if (a < b) (a.toLong()..b.toLong()).sum()
    else (b.toLong()..a.toLong()).sum()

fun solution01x02(a: Int, b: Int): Long =
    (abs(a - b) + 1L) * (a + b) / 2L