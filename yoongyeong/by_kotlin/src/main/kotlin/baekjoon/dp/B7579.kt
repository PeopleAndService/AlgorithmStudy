package baekjoon.dp

import java.util.*

// 앱

fun main() {
    val br = System.`in`.bufferedReader()
    val n: Int; val m: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }

    val bytes = with(StringTokenizer(br.readLine())) { IntArray(n) { nextToken().toInt()} }
    val costs = with(StringTokenizer(br.readLine())) { IntArray(n) { nextToken().toInt()} }
    val dp = Array(n) { IntArray(10_001) }

    var answer = Int.MAX_VALUE

    for (i in 0 until n) {
        val cost = costs[i]
        val memory = bytes[i]
        for (j in 0 until 10_001) {
            if (i == 0) {
                if (j >= cost) dp[i][j] = memory
            } else {
                dp[i][j] = if (j >= cost) maxOf(dp[i-1][j-cost]+memory, dp[i-1][j]) else dp[i-1][j]
            }

            if (dp[i][j] >= m) answer = minOf(answer, j)
        }
    }

    print(answer)
}