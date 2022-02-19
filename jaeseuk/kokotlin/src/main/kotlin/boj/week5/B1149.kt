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
    val cost = Array(n) { StringTokenizer(br.readLine()).run { IntArray(3) { nextToken().toInt() } } }

    for (i in 1 until n) {
        cost[i][0] += minOf(cost[i - 1][1], cost[i - 1][2])
        cost[i][1] += minOf(cost[i - 1][0], cost[i - 1][2])
        cost[i][2] += minOf(cost[i - 1][0], cost[i - 1][1])
    }

    val answer = minOf(cost[n - 1][0], cost[n - 1][1], cost[n - 1][2])
    bw.append("$answer")
    bw.flush()
    bw.close()
}