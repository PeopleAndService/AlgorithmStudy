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

// 없는 숫자 더하기
fun solution02(numbers: IntArray) =  45 - numbers.sum()

// 평균 구하기
fun solution03(arr: IntArray) =  arr.sum() / arr.size.toDouble()

fun solution03x01(arr: IntArray) = arr.average()

// 음양 더하기
fun solution04(absolutes: IntArray, signs: BooleanArray): Int {
    var answer = 0
    for (i in signs.indices) {
        if (signs[i]) answer+= absolutes[i]
        else answer -= absolutes[i]
    }
    return answer
}

fun solution04x01(absolutes: IntArray, signs: BooleanArray) =
    absolutes.foldIndexed(0) { idx, acc, num -> acc + if (signs[idx]) num else -num }

fun solution04x02(absolutes: IntArray, signs: BooleanArray): Int {
    val toIntSignsArray = signs.map { if (it) 1 else -1 }
    return absolutes.zip(toIntSignsArray).map { it.first * it.second }.sum()
}

