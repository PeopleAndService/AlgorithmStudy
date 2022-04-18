package dp

import java.util.StringTokenizer

// 전깃줄

private val br = System.`in`.bufferedReader()
private val n = br.readLine().toInt()
private val electricPole = Array(n) { IntArray(2) }
private val dp = IntArray(n)

fun main() {
    for (idx in 0 until n) {
        with(StringTokenizer(br.readLine())) {
            electricPole[idx][0] = nextToken().toInt()
            electricPole[idx][1] = nextToken().toInt()
        }
    }

    electricPole.sortBy { it[0] }

    var result = 0

    for (i in 0 until n) {
        result = maxOf(solution(i), result)
    }

    print(n - result)
}

private fun solution(number: Int): Int {
    if (dp[number] == 0) { // 탐색 X
        dp[number] = 1

        for (i in number+1 until n) {
            if (electricPole[number][1] < electricPole[i][1]) {
                dp[number] = maxOf(dp[number], solution(i) + 1)
            }
        }
    }

    return dp[number]
}