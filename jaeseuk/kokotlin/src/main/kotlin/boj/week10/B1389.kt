package boj.week10

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

//  케빈 베이컨의 6단계 법칙

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { row -> IntArray(n + 1) { col -> if (row == col) 0 else 100 } }

    repeat(m) {
        StringTokenizer(br.readLine()).run {
            val a = nextToken().toInt()
            val b = nextToken().toInt()

            graph[a][b] = 1
            graph[b][a] = 1
        }
    }

    for (k in 1..n) {
        for (a in 1..n) {
            for (b in 1..n) {
                graph[a][b] = minOf(graph[a][b], graph[a][k] + graph[k][b])
            }
        }
    }

    var answer = 100 to 100

    for (i in 1..n) {
        val bacon = graph[i].sum() - graph[i][0]
        answer = minOf(answer, i to bacon, compareBy({ it.second }, { it.first }))
    }

    bw.append("${answer.first}")
    bw.flush()
    bw.close()
}