package boj.week4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val ropes = Array(n) { br.readLine().toInt() }
    ropes.sort()

    var answer = 0

    for (i in 0 until n) {
        answer = maxOf(ropes[i] * (n - i), answer)
    }

    bw.append("$answer")
    bw.flush()
    bw.close()
}