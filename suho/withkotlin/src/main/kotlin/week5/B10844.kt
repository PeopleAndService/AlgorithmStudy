package week5

/*
플랫폼 : 백준
문제번호 : 10844
문제제목 : 쉬운 계단 수
난이도 : 실버 1
제한사항 : 1초/256MB
알고리즘 분류 : DP

알고리즘 설명
1. n자리의 수에 대해 각 자리에 0~9가 온 경우 체크
2. 첫번째 자리 수는 다 1
3. 현재 숫자가 0이 되려면 이전 자리가 1일 수 밖에 없음
4. 현재 숫자가 9가 되려면 이전 자리가 8일 수 밖에 없음
5. 나머지 경우는 이전 숫자 또는 다음 숫자의 합

채점 결과 : 136ms/18404KB
풀이 날짜 : 2022/02/19
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private const val MOD = 1000000000

fun main() {
    val n = br.readLine().toInt()

    val dp = Array(n+1) { LongArray(10) }

    for (num in 1..9) dp[1][num] = 1

    for (idx in 2..n) {
        repeat(10) { num ->
            dp[idx][num] = when (num) {
                0 -> dp[idx-1][1] % MOD
                9 -> dp[idx-1][8] % MOD
                else -> (dp[idx-1][num-1] + dp[idx-1][num+1]) % MOD
            }
        }
    }

    bw.write("${dp[n].sum() % MOD}")
    bw.close()
    br.close()
}