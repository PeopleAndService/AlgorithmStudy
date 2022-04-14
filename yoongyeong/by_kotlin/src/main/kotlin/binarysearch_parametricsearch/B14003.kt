package binarysearch_parametricsearch

import java.util.StringTokenizer

// 가장 긴 증가하는 부분 수열 5

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()

    val array = IntArray(n+1)
    val dp = Array(n+1) { IntArray(2) }
    val trace = IntArray(n+1)

    var end = 0
    val token = StringTokenizer(br.readLine())

    dp[0][0] = Int.MIN_VALUE
    dp[0][1] = -1

    for (x in 1 .. n) {
        array[x] = token.nextToken().toInt()

        var start = 0
        var newEnd = end

        while (start < newEnd) {
            val mid = (start+newEnd) / 2

            if (dp[mid][0] >= array[x]) newEnd = mid
            else start = mid+1
        }

        if (end == newEnd && dp[end][0] < array[x]) {
            end++; newEnd++
        }

        dp[newEnd][0] = array[x]
        dp[newEnd][1] = x
        trace[x] = dp[newEnd - 1][1]

    }

    bw.write("$end\n")

    var last = dp[end][1]
    val answer = IntArray(end)

    for (x in end-1 downTo 0) {
        answer[x] = array[last]
        last = trace[last]
    }

    for (x in 0 until end) {
        bw.write("${answer[x]} ")
    }

    bw.close()
    br.close()

}