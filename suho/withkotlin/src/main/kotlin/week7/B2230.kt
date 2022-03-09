package week7

import java.util.StringTokenizer
import kotlin.math.min

/*
플랫폼 : 백준
문제번호 : 2230
문제제목 : 수 고르기
난이도 : 골드 5
제한사항 : 2초/128MB
알고리즘 분류 : 정렬, 투 포인터

알고리즘 설명
투 포인터 조작

채점 결과 : 324ms/27436KB
풀이 날짜 : 2022/03/09
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n: Int
    val m: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    val arr = IntArray(n) { br.readLine().toInt() }.apply { sort() }
    var start = 0
    var end = 0
    var answer = Int.MAX_VALUE
    while (end in start until n) {
        val gap = arr[end] - arr[start]
        if (gap < m) end++
        else {
            answer = min(answer, gap)
            start++
        }
    }
    bw.write("$answer")
    bw.close()
    br.close()
}