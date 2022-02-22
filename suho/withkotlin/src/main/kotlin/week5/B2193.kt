package week5

/*
플랫폼 : 백준
문제번호 : 2193
문제제목 : 이친수
난이도 : 실버 3
제한사항 : 2초/128MB
알고리즘 분류 : DP

알고리즘 설명
"11"의 연속된 패턴이 나오면 안됌
그래서 해당 자리에 1을 놓으려면 i-2에 이어서 놔야하고 해당 자리에 0을 놓으려면 i-1에 이어서 놓으면 되기 때문에
dp[i] = dp[i-2] + dp[i-1]이 점화식
* Long 범위인 점에 유의

채점 결과 : 92ms/12328KB
풀이 날짜 : 2022/02/22
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    when(val n = br.readLine().toInt()) {
        1, 2 -> bw.write("1")
        else -> {
            val dp = LongArray(n+1).also { it[1] = 1; it[2] = 1 }
            for (i in 3..n) {
                dp[i] = dp[i-2] + dp[i-1]
            }
            bw.write("${dp[n]}")
        }
    }
    bw.close()
    br.close()
}