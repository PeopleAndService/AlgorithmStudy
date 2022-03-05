package boj.week7

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

//  다이어트

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val g = br.readLine().toInt()

    var start = 1
    var end = 2

    val answer = mutableListOf<Int>()

    while (true) {
        if (end + start > 100_000) break

        val cur = (end - start) * (end + start)

        if (cur <= g) {
            if (cur == g) answer.add(end)
            end++
        } else {
            start++
        }
    }

    if (answer.isEmpty()) bw.append("-1")
    else bw.append(answer.joinToString("\n"))

    bw.flush()
    bw.close()
}