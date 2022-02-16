package boj.week4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var s = br.readLine().toLong()
    var num = 1L

    while (s > 0) {
        s -= num
        num++
    }

    val answer = if (s == 0L) num - 1 else num - 2
    bw.append("$answer")
    bw.flush()
    bw.close()
}