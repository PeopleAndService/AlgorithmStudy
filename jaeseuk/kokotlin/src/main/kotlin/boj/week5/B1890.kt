package boj.week5

//  점프

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val board = Array(n) { StringTokenizer(br.readLine()).run { IntArray(n) { nextToken().toInt() } } }

    val dp = Array(n) { LongArray(n) }
    dp[0][0] = 1

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (i == n - 1 && j == n - 1) break

            if (dp[i][j] > 0) {
                val right = j + board[i][j]
                val down = i + board[i][j]

                if (right < n) dp[i][right] += dp[i][j]
                if (down < n) dp[down][j] += dp[i][j]
            }
        }
    }

    bw.append("${dp[n - 1][n - 1]}")
    bw.flush()
    bw.close()
}