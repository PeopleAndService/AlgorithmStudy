package boj.code_plus1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

//  약수의 합

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val g = LongArray(1_000_001) { 1 }

    for (i in 2..1_000_000) {
        var j = 1

        while (i * j <= 1_000_000) {
            g[i * j] = g[i * j] + i
            j++
        }
    }

    for (i in 2..1_000_000) {
        g[i] += g[i - 1]
    }

    repeat(br.readLine().toInt()) {
        bw.write("${g[br.readLine().toInt()]}")
        bw.newLine()
    }

    bw.flush()
    bw.close()
}