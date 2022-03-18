package tree

import java.util.StringTokenizer

// 트리의 지름

private val br = System.`in`.bufferedReader()
private val n = br.readLine().toInt()
private val graph = Array(n+1) { mutableListOf<Int>() }
private val distances = Array(n+1) { mutableListOf<Int>() }

private val visited = BooleanArray(n+1)
private var answer = Int.MIN_VALUE
private var point = 0


fun main() {
    repeat(n-1) {
        with(StringTokenizer(br.readLine())) {
            val a = nextToken().toInt(); val b = nextToken().toInt(); val w = nextToken().toInt()
            graph[a].add(b); distances[a].add(w)
            graph[b].add(a); distances[b].add(w)
        }
    }

    dfs(1, 0)
    visited.fill(false)

    dfs(point, 0)
    println(if (n==1) 0 else answer)
}

private fun dfs(v: Int, d: Int) {
    visited[v] = true
    for ((index, node) in graph[v].withIndex()) {
        if (!visited[node]) {
            val distance = d + distances[v][index]
            if (answer < distance) {
                point = node
                answer = distance
            }
            dfs(node, distance)
        }
    }
}