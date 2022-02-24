package week6

import java.util.StringTokenizer
import kotlin.math.max

/*
플랫폼 : 백준
문제번호 : 2512
문제제목 : 예산
난이도 : 실버 3
제한사항 : 1초/128MB
알고리즘 분류 : 이분탐색, 파라매트릭 서치

알고리즘 설명
문제 주석

채점 결과 : 180ms/19460KB
풀이 날짜 : 2022/02/24
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val buckets = with(StringTokenizer(br.readLine())) { IntArray(n) { nextToken().toInt() } }
    val total = br.readLine().toInt()
    br.close()

    var start = 0
    var end = buckets.maxOf { it }
    var answer = 0

    while (start <= end) {
        // 현재 탐색할 상한
        val mid = (start + end) / 2

        val sum = buckets.sumOf { bucket -> if (bucket >= mid) mid else bucket }
        if (sum > total) {
            // 총 예산을 초과하는 경우, 상한을 줄임
            end = mid - 1
        } else {
            // 아니면 상한을 늘려보자
            start = mid + 1
            answer = max(answer, mid)
        }
    }

    bw.write("$answer")
    bw.close()
}