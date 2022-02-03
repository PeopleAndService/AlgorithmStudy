package boj.backtracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private var n = 0
private var s = 0

private lateinit var numbers: List<Int>

private var answer = 0

fun main() {
    br.readLine().split(" ").run {
        n = first().toInt()
        s = last().toInt()
    }
    numbers = br.readLine().split(" ").map { it.toInt() }

    var sum = 0

    for (i in 0 until n) {
        repeat(n - i) {
            sum += numbers[it]
            solution(sum, it + 1, 1, i + 1)
            sum -= numbers[it]
        }
    }

    bw.append("$answer")
    bw.flush()
    bw.close()
}

private fun solution(sum: Int, start: Int, size: Int, maxSize: Int) {
    if (size == maxSize) {
        if (sum == s) answer++
        return
    }

    var sos = sum

    for (i in start until n) {
        sos += numbers[i]
        solution(sos, i + 1, size + 1, maxSize)
        sos -= numbers[i]
    }
}