package baekjoon.dfs_bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

// 이분 그래프

private val br = BufferedReader(InputStreamReader(System.`in`))
private lateinit var graph: Array<MutableList<Int>>
private lateinit var visited: IntArray
private var v = 0; private var e = 0

fun main() {
    repeat(br.readLine().toInt()) {
        StringTokenizer(br.readLine()).run {
            v = nextToken().toInt()
            e = nextToken().toInt()
        }
        graph = Array(v) { mutableListOf() }
        visited = IntArray(v)

        for (i in 0 until e) {
            StringTokenizer(br.readLine()).run {
                val v1 = nextToken().toInt()
                val v2 = nextToken().toInt()
                graph[v1-1].add(v2-1); graph[v2-1].add(v1-1)
            }
        }

        var isBipartite = true

        for (i in 0 until v) {
            if (visited[i] != 0) continue
            isBipartite = bfs(i)

            if (!isBipartite) break
        }

        println(if(isBipartite) "YES" else "NO")
    }
}

private fun bfs(start: Int): Boolean {
    val queue =  LinkedList<Int>()
    queue.offer(start); visited[start] = 1

    while (queue.isNotEmpty()) {
        val cur = queue.poll()

        for (i in graph[cur]) {
            // 루프가 있다면 false 반환
            if (i == cur) return false

            // 인접 정점이면서 아직 그룹이 정해지지 X
            if (visited[i] == 0) {
                queue.add(i); visited[i] = visited[cur] * -1

            } else if (visited[i] == visited[cur]) return false // 인접했는데 같은 그룹이면
        }
    }

    return true
}