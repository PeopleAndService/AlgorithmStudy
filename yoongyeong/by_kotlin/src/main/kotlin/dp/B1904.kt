package dp

// 01타일

fun main() {
    val n = System.`in`.bufferedReader().readLine().toInt()
    val dp = IntArray(n+2) {1}
    dp[2] = 2

    for (index in 2 .. n) dp[index] = (dp[index-1] + dp[index-2]) % 15746

    print(dp[n])
}