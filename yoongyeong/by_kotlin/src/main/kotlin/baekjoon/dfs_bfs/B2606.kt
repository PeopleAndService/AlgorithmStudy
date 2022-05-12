package baekjoon.dfs_bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

// 바이러스

private var graph = arrayOf<BooleanArray>()
private var visited = booleanArrayOf()
private var n = 0
private val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    n = br.readLine().toInt()
    graph = Array(n) { BooleanArray(n) }; visited = BooleanArray(n)
    repeat(br.readLine().toInt()) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        graph[x-1][y-1] = true; graph[y-1][x-1] = true
    }

    print(virus())
}

private fun virus(): Int {
    var answer = 0
    val list = LinkedList<Int> ()
    list.add(0); visited[0] = true
    while (list.isNotEmpty()) {
        val cur = list.poll()
        for (i in 0 until n) {
            if (!visited[i] && graph[cur][i]) {
                answer += 1; visited[i] = true
                list.add(i)
            }
        }
    }

    return answer
}