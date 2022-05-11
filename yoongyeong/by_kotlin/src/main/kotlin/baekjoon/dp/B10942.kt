package baekjoon.dp

import java.util.StringTokenizer

// 팰린드롬?

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val numbers = with(StringTokenizer(br.readLine())) { IntArray(n) { nextToken().toInt() } }
    val dp = Array(n) { BooleanArray(n) }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (i == j) dp[i][j] = true
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (i+1 == j && numbers[i] == numbers[j]) dp[i][j] = true
        }
    }

    for (i in 2 until n) {
        for (j in 0 until n-i) {
            if (numbers[j] == numbers[i+j] && dp[j+1][i+j-1]) dp[j][i+j] = true
        }
    }

    val m = br.readLine().toInt()
    for (i in 0 until m) {
        with(StringTokenizer(br.readLine())) {
            bw.write(if (dp[nextToken().toInt()-1][nextToken().toInt()-1]) "1\n" else "0\n")
        }
    }

    bw.close(); br.close()
}