package week5

import java.util.StringTokenizer
import kotlin.math.max

/*
플랫폼 : 백준
문제번호 : 2565
문제제목 : 전깃줄
난이도 : 골드 5
제한사항 : 1초/128MB
알고리즘 분류 : DP

알고리즘 설명
LIS(최장 부분 증가 수열) 알고리즘으로 이어지는 전봇대의 가장 긴 부분 증가 수열을 구함
n - LIS 결과의 최대값이 정답이다.

채점 결과 : 164ms/13988KB
풀이 날짜 : 2022/02/20
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val map = sortedMapOf<Int, Int>().apply {
        repeat(n) {
            with(StringTokenizer(br.readLine())) {
                put(nextToken().toInt(), nextToken().toInt())
            }
        }
    }

    val dp = IntArray(n)
    val num = map.values.toIntArray()
    for (i in 0 until n) {
        dp[i] = 1
        for (j in 0 until i) {
            if (num[j] < num[i]) {
                dp[i] = max(dp[i], dp[j] + 1)
            }
        }
    }

    bw.write("${n - dp.maxOf { it }}")
    bw.close()
    br.close()
}