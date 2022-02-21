package boj.week5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val sequence = StringTokenizer(br.readLine()).run { IntArray(n) { nextToken().toInt() } }
    val dp = IntArray(n)

    for (i in 0 until n) {
        dp[i] = 1

        for (j in 0 until i) {
            if (sequence[i] > sequence[j]) {
                dp[i] = maxOf(dp[i], dp[j] + 1)
            }
        }
    }

    bw.append("${dp.maxOrNull()}")
    bw.flush()
    bw.close()
}