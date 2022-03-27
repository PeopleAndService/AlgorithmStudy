package boj.week10

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

//  역사

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { IntArray(n + 1) { Int.MAX_VALUE } }

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }

        graph[a][b] = -1
        graph[b][a] = 1
    }

    for (k in 1..n) {
        for (a in 1..n) {
            for (b in 1..n) {
                graph[a][b] = minOf(graph[a][b], if (graph[a][k] == graph[k][b]) graph[a][k] else Int.MAX_VALUE)
            }
        }
    }

    repeat(br.readLine().toInt()) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }

        bw.append("${if (graph[a][b] == Int.MAX_VALUE) 0 else graph[a][b]}")
        bw.newLine()
    }

    bw.flush()
    bw.close()
}