package boj.code_plus3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

//  N과 M (6)

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private var n = 0
private var m = 0

private lateinit var numbers: IntArray

fun main() {
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }

    numbers = StringTokenizer(br.readLine()).run { IntArray(n) { nextToken().toInt() } }.sortedArray()

    solution(IntArray(m), 0, 0)

    bw.flush()
    bw.close()
}

private fun solution(answer: IntArray, start: Int, step: Int) {
    if (step == m) {
        bw.write(answer.joinToString(" "))
        bw.newLine()
        return
    }

    for (i in start until n) {
        answer[step] = numbers[i]
        solution(answer, i + 1, step + 1)
    }
}