package boj.week5

// 이친수

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val dp = LongArray(n)

    dp[0] = 1
    if (n >= 2) dp[1] = 1

    for (i in 2 until n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }

    bw.append("${dp[n - 1]}")
    bw.flush()
    bw.close()
}