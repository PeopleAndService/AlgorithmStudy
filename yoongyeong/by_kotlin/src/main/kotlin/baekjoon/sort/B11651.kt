package baekjoon.sort

import java.util.StringTokenizer

// 좌표 정렬하기 2

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val graph = mutableListOf<Pair<Int, Int>>()
    repeat(br.readLine().toInt()) {
        with(StringTokenizer(br.readLine())) {
            graph.add(Pair(nextToken().toInt(), nextToken().toInt()))
        }
    }
    graph.sortWith(compareBy({it.second}, {it.first}))

    for ((x, y) in graph) {
        bw.write("$x $y\n")
    }

    bw.close()
}