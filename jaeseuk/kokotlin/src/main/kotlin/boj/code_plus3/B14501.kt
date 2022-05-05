package boj.code_plus3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

//  퇴사

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private val n = br.readLine().toInt()

private val t = IntArray(n)
private val p = IntArray(n)

private var answer = 0

fun main() {
    repeat(n) {
        with(StringTokenizer(br.readLine())) {
            t[it] = nextToken().toInt()
            p[it] = nextToken().toInt()
        }
    }

    solution(0, 0)

    bw.write("$answer")
    bw.flush()
    bw.close()
}

private fun solution(start: Int, sum: Int) {
    for (i in start until n) {
        val next = i + t[i]
        if (next <= n) solution(next, sum + p[i])
    }

    answer = maxOf(answer, sum)
}