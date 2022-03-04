package boj.week7

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

//  부분합

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, s) = br.readLine().split(" ").map { it.toInt() }
    val prefixSum = StringTokenizer(br.readLine()).run { IntArray(n + 1) { if (it == 0) 0 else nextToken().toInt() } }

    for (i in 2..n) {
        prefixSum[i] += prefixSum[i - 1]
    }

    var start = 0
    var end = 1

    var answer = 100_000

    if (prefixSum.last() < s) {
        answer = 0
    } else {
        while (end in (start + 1)..n) {
            if (prefixSum[end] - prefixSum[start] >= s) {
                answer = minOf(answer, end - start)
                start++
            } else {
                end++
            }
        }
    }

    bw.append("$answer")
    bw.flush()
    bw.close()
}