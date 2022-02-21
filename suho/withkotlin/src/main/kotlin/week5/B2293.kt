package week5

import java.util.StringTokenizer

/*
플랫폼 : 백준
문제번호 : 2293
문제제목 : 동전 1
난이도 : 골드 5
제한사항 : 0.5초/4MB
알고리즘 분류 : DP

알고리즘 설명
1. 입력으로 들어오는 동전의 가치로 각 금액을 만들 수 있는 경우를 구할 때
2. 이전에 구했던 동전의 가치로 만들 수 있는 경우의 수를 활용한다.

채점 결과 : 104ms/12600KB
풀이 날짜 : 2022/02/21
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n: Int
    val k: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        k = nextToken().toInt()
    }
    val dp = IntArray(k+1)
    dp[0] = 1
    repeat(n) {
        br.readLine().toInt().also { coin ->
            for (value in coin..k) {
                dp[value] += dp[value-coin]
            }
        }
    }
    bw.write("${dp[k]}")
    bw.close()
    br.close()
}