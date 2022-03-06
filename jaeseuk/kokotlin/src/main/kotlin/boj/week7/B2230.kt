package boj.week7

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

//  수 고르기

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val seq = IntArray(n) { br.readLine().toInt() }.sortedArray()

    var start = 0
    var end = 0

    var answer = Int.MAX_VALUE

    while (end in start until n) {
        if (seq[end] - seq[start] >= m) {
            answer = minOf(answer, seq[end] - seq[start])
            start++
        } else {
            end++
        }
    }

    bw.append("$answer")
    bw.flush()
    bw.close()
}