package boj.week6

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// 과자 나눠주기

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val snacks = StringTokenizer(br.readLine()).run { IntArray(n) { nextToken().toInt() } }

    var start = 1
    var end = snacks.maxOrNull()!!

    var answer = 0

    while (start <= end) {
        val mid = (start + end) / 2
        var cnt = 0

        for (snack in snacks) {
            if (snack >= mid) cnt += snack / mid
        }

        if (cnt >= m) {
            answer = maxOf(answer, mid)
            start = mid + 1
        } else {
            end = mid - 1
        }
    }
    bw.append("$answer")
    bw.flush()
    bw.close()
}