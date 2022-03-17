package boj.week8

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

//  트리

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var caseNo = 1

    while (true) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }

        if (n == 0 && m == 0) break

        val graph = Array<MutableList<Int>>(n + 1) { mutableListOf() }
        val visited = BooleanArray(n + 1)

        repeat(m) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }

            graph[a].add(b)
            graph[b].add(a)
        }

        var treeCnt = 0

        for (i in 1..n) {
            if (!visited[i] && bfs(graph, visited, i)) treeCnt++
        }

        val answer = when (treeCnt) {
            0 -> "No trees."
            1 -> "There is one tree."
            else -> "A forest of $treeCnt trees."
        }

        bw.append("Case $caseNo: $answer")
        bw.newLine()

        caseNo++
    }

    bw.flush()
    bw.close()
}

private fun bfs(graph: Array<MutableList<Int>>, visited: BooleanArray, start: Int): Boolean {
    var result = true
    val q = LinkedList<Int>()

    q.add(start)

    while (q.isNotEmpty()) {
        val now = q.poll()

        if (visited[now]) result = false

        visited[now] = true

        graph[now].forEach {
            if (!visited[it]) q.add(it)
        }
    }

    return result
}