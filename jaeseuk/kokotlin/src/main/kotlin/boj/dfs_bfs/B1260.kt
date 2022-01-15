package boj.dfs_bfs

import java.util.*

fun main() {
    val (n, m, v) = readLine()!!.split(' ').map { it.toInt() }
    val graph = List<MutableList<Int>>(n + 1) { mutableListOf() }
    val visited = MutableList(n + 1){ false }

    repeat(m) {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }
    graph.forEach { it.sort() }

    dfs(graph, visited, v)
    visited.fill(false)
    println()
    bfs(graph, visited, v)
}

private fun dfs(graph: List<MutableList<Int>>, visited: MutableList<Boolean>, start: Int) {
    print("$start ")
    visited[start] = true

    for (v in graph[start]) {
        if (!visited[v]) dfs(graph, visited, v)
    }
}

private fun bfs(graph: List<MutableList<Int>>, visited: MutableList<Boolean>, start: Int) {
    val q = LinkedList<Int>()
    q.add(start)

    while (q.isNotEmpty()) {
        val now = q.poll()

        if (!visited[now]) {
            print("$now ")
            visited[now] = true
        }

        for (v in graph[now]) {
            if (!visited[v]) q.add(v)
        }
    }
}
