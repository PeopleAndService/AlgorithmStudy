package baekjoon.dijkstra

import java.util.PriorityQueue
import java.util.StringTokenizer

// 특정한 최단 경로

fun main() {
    val br = System.`in`.bufferedReader()
    val n: Int; val e: Int
    with(StringTokenizer(br.readLine())) { n = nextToken().toInt(); e = nextToken().toInt() }
    val graph = Array<MutableList<Pair<Int, Int>>>(n+1) { mutableListOf() }
    repeat(e) {
        with(StringTokenizer(br.readLine())) {
            val a = nextToken().toInt(); val b = nextToken().toInt(); val c = nextToken().toInt()
            graph[a].add(Pair(b, c)); graph[b].add(Pair(a, c))
        }
    }
    val a: Int; val b: Int
    with(StringTokenizer(br.readLine())) { a = nextToken().toInt(); b = nextToken().toInt() }

    val cost1 = dijkstra(n, 1, graph)
    val costA = dijkstra(n, a, graph)
    val costB = dijkstra(n, b, graph)

    // Case 1 : 1번 정점 -> A 정점 -> B 정점 -> N번 정점
    // Case 2 : 1번 정점 -> B 정점 -> A 정점 -> N번 정점

    if (cost1[a] == Int.MAX_VALUE || cost1[b] == Int.MAX_VALUE || costA[b] == Int.MAX_VALUE || costA[n] == Int.MAX_VALUE
        || costB[a] == Int.MAX_VALUE || costB[n] == Int.MAX_VALUE) print(-1)
    else {
        print(minOf(cost1[a]+costA[b]+costB[n], cost1[b]+costB[a]+costA[n]))
    }

}

private fun dijkstra(n: Int, start: Int, graph: Array<MutableList<Pair<Int, Int>>>): IntArray {
    val cost = IntArray(n+1) { Int.MAX_VALUE }
    val pq = PriorityQueue<Pair<Int, Int>> (compareBy { it.first })
    pq.add(Pair(start, 0)); cost[start] = 0
    
    while (pq.isNotEmpty()) {
        val (current, distance) = pq.poll()
        if (cost[current] < distance) continue
        
        graph[current].forEach { (next, nextDistance) ->
            (nextDistance + distance).run {
                if (this < cost[next]) {
                    cost[next] = this
                    pq.add(Pair(next, this))
                }
            }
        }
    }
    return cost
}