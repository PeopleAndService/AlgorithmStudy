package baekjoon.dp

import java.util.StringTokenizer

// 외판원 순회

private val br = System.`in`.bufferedReader()
private val n = br.readLine().toInt()
private const val INF = 11000000
private val shlN = 1 shl n
private val map = Array(n) { with(StringTokenizer(br.readLine())) { IntArray(n) { nextToken().toInt() } } }
private val dp = Array(n) { IntArray(shlN) { -1 } }

fun main() {
    print(dfs())
}


private fun dfs(city: Int = 0, visit: Int = 1): Int {
    if (visit == shlN - 1) {
        if (map[city][0] == 0) return INF
        return map[city][0]
    }

    if (dp[city][visit] != -1) return dp[city][visit]

    dp[city][visit] = INF

    for (i in 0 until n) {
        if ((visit and (1 shl i)) == 0 && map[city][i] != 0) {
            dp[city][visit] = minOf(dp[city][visit], dfs(i, visit or (1 shl i)) + map[city][i])
        }
    }

    return dp[city][visit]
}