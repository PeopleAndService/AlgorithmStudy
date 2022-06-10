package baekjoon.dfs_bfs

import java.util.StringTokenizer

// 연결 요소의 개수

private var cnt = 0
private lateinit var graph: Array<MutableList<Int>>
private lateinit var visited: BooleanArray

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    graph = Array(n + 1) { mutableListOf<Int>() }
    visited = BooleanArray(n + 1)

    for (i in 0 until m) {
        with(StringTokenizer(br.readLine())) {
            val a = nextToken().toInt()
            val b = nextToken().toInt()

            graph[a].add(b)
            graph[b].add(a)
        }
    }

    for (i in 1..n) {
        if (!visited[i]) {
            dfs(i)
            cnt += 1
        }
    }

    print(cnt)
}

private fun dfs(now: Int) {
    visited[now] = true
    for (i in graph[now]) {
        if (!visited[i]) {
            dfs(i)
        }
    }
}