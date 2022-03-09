package boj.week7

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

//  팀 빌딩

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val abilities = StringTokenizer(br.readLine()).run { IntArray(n) { nextToken().toInt() } }

    var start = 0
    var end = n - 1

    var answer = 0

    while (start < end) {
        answer = maxOf(answer, (end - start - 1) * minOf(abilities[start], abilities[end]))

        if (abilities[start] > abilities[end]) end--
        else start++
    }

    bw.append("$answer")
    bw.flush()
    bw.close()
}