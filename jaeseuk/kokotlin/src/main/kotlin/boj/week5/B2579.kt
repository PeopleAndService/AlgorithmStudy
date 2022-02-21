package boj.week5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val scores = IntArray(n) { br.readLine().toInt() }

    val dp = IntArray(n)
    dp[0] = scores[0]

    if (n >= 2) dp[1] = maxOf(scores[0] + scores[1], scores[1])
    if (n >= 3) dp[2] = maxOf(scores[2] + scores[0], scores[2] + scores[1])

    for (i in 3 until n) {
        dp[i] = maxOf(scores[i] + dp[i - 2], scores[i] + scores[i - 1] + dp[i - 3])
    }

    bw.append("${dp[n - 1]}")
    bw.flush()
    bw.close()
}