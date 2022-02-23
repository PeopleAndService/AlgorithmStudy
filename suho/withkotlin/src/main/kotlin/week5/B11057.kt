package week5

/*
플랫폼 : 백준
문제번호 : 11057
문제제목 : 오르막 수
난이도 : 실버 1
제한사항 : 1초/256MB
알고리즘 분류 : DP

알고리즘 설명
1. 쉬운 계단 수 문제랑 비슷
2. 대신 오름차순 수열만 가능

채점 결과 : 136ms/18396KB
풀이 날짜 : 2022/02/23
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private const val MOD = 10007

fun main() {
    val n = br.readLine().toInt()
    val dp = Array(n+1) { IntArray(10)}
    repeat(10) { num ->
        dp[1][num] = 1
    }
    for (idx in 2..n) {
        repeat(10) { num ->
            for (value in 0..num) {
                dp[idx][num] += dp[idx-1][value]
                dp[idx][num] %= MOD
            }
        }
    }
    bw.write("${dp[n].sum() % MOD}")
    bw.close()
    br.close()
}