package baekjoon.minimumspaningtree

import java.util.PriorityQueue
import java.util.StringTokenizer

// 최소 스패닝 트리

private var v = 0; private var e= 0
private lateinit var graph: Array<MutableList<Pair<Int, Int>>>

fun main() {
    val br = System.`in`.bufferedReader()
    var minimum = 0
    with(StringTokenizer(br.readLine())) {
        v = nextToken().toInt(); e = nextToken().toInt()
    }
    graph = Array(v+1) { mutableListOf<Pair<Int, Int>>() }
    repeat(e) {
        with(StringTokenizer(br.readLine())) {
            val a = nextToken().toInt()
            val b = nextToken().toInt()
            val c = nextToken().toInt()
            graph[a].add(Pair(b, c))
            graph[b].add(Pair(a, c))
        }
    }

    print(prim())
}

private fun prim(): Int {
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    val visited = BooleanArray(v+1)
    var minimum = 0
    pq.add(Pair(1, 0))

    while(pq.isNotEmpty()) {
        val (node, weight) = pq.poll()

        if (!visited[node]) {
            visited[node] = true
            minimum += weight
            for (pair in graph[node]) {
                if (!visited[pair.first]) pq.add(pair)
            }
        }

    }

    return minimum
}