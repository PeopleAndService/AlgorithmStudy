package baekjoon.dfs_bfs

import java.io.*
import java.lang.StringBuilder
import java.util.*

// DFS와 BFS

private var graph = arrayOf<IntArray>()
private var visited = booleanArrayOf()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m, v) = this.readLine().split(" ").map { it.toInt() }
    graph = Array(n) {IntArray(n)}
    visited = BooleanArray(n)

    repeat(m) {
        val (x, y) = this.readLine().split(" ").map { it.toInt() }
        graph[x-1][y-1] = 1
        graph[y-1][x-1] = 1
    }

    visited.fill(false)
    println(dfs(n, v-1).trimEnd())

    visited.fill(false)
    println(bfs(n, v-1).trimEnd())
}

private fun dfs(n: Int, v: Int): String {
    val sb = StringBuilder()
    visited[v] = true
    sb.append("${v+1} ")

    for (i in 0 until n) if (graph[v][i] == 1 && !visited[i]) sb.append(dfs(n, i))

    return sb.toString()
}

private fun bfs(n: Int, v: Int): String {
    val sb = StringBuilder()
    val list = LinkedList<Int>()

    list.add(v); visited[v] = true
    sb.append("${v+1} ")

    while (list.isNotEmpty()) {
        val cur = list.poll()

        for (i in 0 until n) {
            if (graph[cur][i] == 1 && !visited[i]) {
                list.add(i); visited[i] = true
                sb.append("${i+1} ")
            }
        }
    }

    return sb.toString()
}