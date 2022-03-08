package week7

import java.util.*
import kotlin.math.abs
import kotlin.math.min

/*
플랫폼 : 백준
문제번호 : 2467
문제제목 : 용액
난이도 : 골드 5
제한사항 : 1초/128MB
알고리즘 분류 : 이분 탐색, 두 포인터

알고리즘 설명
양 끝에서 시작하는 투 포인터

채점 결과 : 324ms/36836KB
풀이 날짜 : 2022/03/08
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val liquid = with(StringTokenizer(br.readLine())) { LongArray(n) { nextToken().toLong() }.apply { sort() } }
    var start = 0
    var end = liquid.lastIndex
    var minValue = Long.MAX_VALUE
    var lIdx = 0
    var rIdx = 0
    while (start < end) {
        val sum = liquid[start] + liquid[end]
        abs(sum).let {
            if (it < minValue) {
                minValue = min(minValue, it)
                lIdx = start
                rIdx = end
            }
        }

        if (sum < 0) {
            start++
        } else {
            end--
        }
    }
    bw.write("${liquid[lIdx]} ${liquid[rIdx]}")
    bw.close()
    br.close()
}