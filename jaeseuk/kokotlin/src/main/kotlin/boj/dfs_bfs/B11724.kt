package boj.dfs_bfs

fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val graph = List<MutableList<Int>>(n + 1) { mutableListOf() }
    val visited = MutableList(n + 1) { false }

    repeat(m) {
        val (u, v) = readLine()!!.split(' ').map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }

    var answer = 0

    for (i in 1..n) {
        if (!visited[i]) {
            answer += 1
            dfs(graph, visited, i)
        }
    }

    println(answer)
}

private fun dfs(graph: List<MutableList<Int>>, visited: MutableList<Boolean>, start: Int) {
    visited[start] = true

    for (v in graph[start]) {
        if (!visited[v]) dfs(graph, visited, v)
    }
}