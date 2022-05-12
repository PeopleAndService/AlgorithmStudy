package baekjoon.twopointer_prefixsum

import java.util.StringTokenizer

// 구간 합 구하기 4

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n: Int; val m: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    val dp = IntArray(n+1)
    with(StringTokenizer(br.readLine())) {
        for (index in 1 .. n) {
            dp[index] = dp[index-1] + nextToken().toInt()
        }
    }

    repeat(m) {
        with(StringTokenizer(br.readLine())) {
            val i = nextToken().toInt()
            val j = nextToken().toInt()
            bw.write("${dp[j] - dp[i-1]}\n")
        }
    }

    bw.close()
    br.close()
}