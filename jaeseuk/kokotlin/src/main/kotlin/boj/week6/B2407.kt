package boj.week6

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.math.BigInteger

//  조합

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val dp = Array(n + 1) { BigInteger("0") }
    dp[1] = BigInteger("1")

    for (i in 2..n) {
        dp[i] = BigInteger("$i") * dp[i - 1]
    }

    bw.append("${dp[n] / (dp[m] * dp[n - m])}")
    bw.flush()
    bw.close()
}