package boj.week7

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

//  먹을 것인가 먹힐 것인가

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    repeat(br.readLine().toInt()) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }

        val a = StringTokenizer(br.readLine()).run { IntArray(n) { nextToken().toInt() }.sortedArray() }
        val b = StringTokenizer(br.readLine()).run { IntArray(m) { nextToken().toInt() }.sortedArray() }

        var answer = 0

        var ap = 0
        var bp = 0

        while (ap < n && bp < m) {
            if (a[ap] > b[bp]) {
                answer += n - ap
                bp++
            } else {
                ap++
            }
        }

        bw.append("$answer")
        bw.newLine()
    }

    bw.flush()
    bw.close()
}