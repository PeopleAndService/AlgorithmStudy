package baekjoon.dp

// 계단 오르기

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val stair = IntArray(n) {br.readLine().toInt()}
    val dp = IntArray(n) {stair[0]}

    if (n >= 2) dp[1] = maxOf(stair[0] + stair[1], stair[1])
    if (n >= 3) dp[2] = maxOf(stair[0] + stair[2], stair[1] + stair[2])

    for (i in 3 until n) dp[i] = maxOf(stair[i] + dp[i - 2], stair[i] + stair[i - 1] + dp[i - 3])

    print(dp[n-1])
}