package baekjoon.dp

import java.util.*

// 가장 긴 증가하는 부분 수열

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val dp = IntArray(n) {1}
    val array = StringTokenizer(br.readLine()).run { IntArray(n) {nextToken().toInt()} }

    for(i in 1 until n) {
        for(j in 0 until i) {
            if (array[j] < array[i]) dp[i] = maxOf(dp[i], dp[j]+1)
        }
    }

    print(dp.maxOrNull())
}