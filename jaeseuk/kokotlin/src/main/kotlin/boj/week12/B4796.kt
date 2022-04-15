package boj.week12

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

//  캠핑

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var case = 1

    while (true) {
        val (l, p, v) = br.readLine().split(" ").map { it.toInt() }

        if (l == 0 && p == 0 && v == 0) break

        bw.write("Case ${case++}: ${l * (v / p) + minOf(v % p, l)}")
        bw.newLine()
    }

    bw.flush()
    bw.close()
}