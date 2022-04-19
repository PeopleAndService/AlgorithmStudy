package boj.code_plus2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

//  날짜 계산

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (E, S, M) = br.readLine().split(" ").map { it.toInt() }

    var e = 1
    var s = 1
    var m = 1

    var answer = 1

    while (E != e || S != s || M != m) {
        e = e % 15 + 1
        s = s % 28 + 1
        m = m % 19 + 1
        answer++
    }

    bw.write("$answer")
    bw.flush()
    bw.close()
}