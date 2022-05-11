package baekjoon.dp

import java.util.StringTokenizer

// 평범한 배낭

fun main() {
    val br = System.`in`.bufferedReader()
    val n: Int; val k: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        k = nextToken().toInt()
    }

    val weights = IntArray(n+1)
    val costs = IntArray(n+1)
    val dp = IntArray(k+1)

    for (index in 1 .. n) {
        with(StringTokenizer(br.readLine())) {
            weights[index] = nextToken().toInt()
            costs[index] = nextToken().toInt()
        }
    }

    for (i in 1 .. n) {
        var j = k
        while (j - weights[i] >= 0) {
            dp[j]  = maxOf(dp[j], dp[j-weights[i]] + costs[i])
            j--
        }
    }

    print(dp[k])
}