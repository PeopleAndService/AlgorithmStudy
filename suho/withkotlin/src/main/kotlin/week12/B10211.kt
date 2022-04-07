package week12

import java.util.StringTokenizer

/*
플랫폼 : 백준
문제번호 : 10211
문제제목 : Maximum Subarray
난이도 : 실버 3
제한사항 : 1초/256MB
알고리즘 분류 : DP, 브루트포스 알고리즘, 누적 합

알고리즘 설명
1. 누적합의 가장 큰 구간을 찾는다.
2. 누적합이 음수가 되면 0으로 바꿔줌

채점 결과 : 156ms/19432KB
풀이 날짜 : 2022/04/07
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    repeat(br.readLine().toInt()) {
        val n = br.readLine().toInt()
        val arr = StringTokenizer(br.readLine()).run {
            IntArray(n) { nextToken().toInt() }
        }
        val dp = IntArray(n)

        var answer = arr[0]
        dp[0] = arr[0]
        for (i in 1..arr.lastIndex) {
            if (dp[i - 1] < 0) dp[i - 1] = 0
            dp[i] = dp[i - 1] + arr[i]
            answer = maxOf(answer, dp[i])
        }

        bw.write("$answer")
        bw.newLine()
    }
    bw.close()
    br.close()
}