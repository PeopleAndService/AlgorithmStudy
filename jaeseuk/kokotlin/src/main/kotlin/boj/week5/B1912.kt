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
    val numbers = StringTokenizer(br.readLine()).run { IntArray(n) { nextToken().toInt() } }

    var answer = numbers[0]

    for (i in 1 until n) {
        numbers[i] = maxOf(numbers[i], numbers[i] + numbers[i - 1])
        answer = maxOf(answer, numbers[i])
    }

    bw.append("$answer")
    bw.flush()
    bw.close()
}