package boj.week5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val dp = LongArray(91)

    dp[0] = 0
    dp[1] = 1

    for (i in 2..90) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }

    bw.append("${dp[n]}")
    bw.flush()
    bw.close()
}