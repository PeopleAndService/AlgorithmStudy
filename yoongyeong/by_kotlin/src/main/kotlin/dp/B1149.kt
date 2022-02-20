package dp

import java.util.*

// RGB 거리

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val dp = Array(n) {StringTokenizer(br.readLine()).run { IntArray(3) {nextToken().toInt()} }}

    for (index in 1 until n) {
        dp[index][0] += minOf(dp[index-1][1], dp[index-1][2])
        dp[index][1] += minOf(dp[index-1][0], dp[index-1][2])
        dp[index][2] += minOf(dp[index-1][0], dp[index-1][1])
    }

    print(minOf(dp[n-1][0], dp[n-1][1], dp[n-1][2]))

}