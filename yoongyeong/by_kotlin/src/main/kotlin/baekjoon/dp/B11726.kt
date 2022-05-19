package baekjoon.dp

// 2xn 타일링

fun main() {
    val n = readLine()!!.toInt()
    val dp = IntArray(n+1) { 1 }

    for (index in 2 .. n) {
        dp[index] = (dp[index-1] + dp[index-2] ) % 10_007
    }

    print(dp[n])
}