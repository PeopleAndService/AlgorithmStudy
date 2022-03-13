package boj.week8

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

//  특정한 최단 경로

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private var n = 0
private var e = 0

private lateinit var graph: Array<MutableList<Pair<Int, Int>>>

private var v1 = 0
private var v2 = 0

fun main() {
    StringTokenizer(br.readLine()).run {
        n = nextToken().toInt()
        e = nextToken().toInt()
    }

    graph = Array(n + 1) { mutableListOf() }

    repeat(e) {
        StringTokenizer(br.readLine()).run {
            val a = nextToken().toInt()
            val b = nextToken().toInt()
            val c = nextToken().toInt()

            graph[a].add(b to c)
            graph[b].add(a to c)
        }
    }

    StringTokenizer(br.readLine()).run {
        v1 = nextToken().toInt()
        v2 = nextToken().toInt()
    }

    val v1Tov2 = dijkstra(1, v1).toLong() + dijkstra(v1, v2) + dijkstra(v2, n)
    val v2Tov1 = dijkstra(1, v2).toLong() + dijkstra(v2, v1) + dijkstra(v1, n)

    val answer = minOf(v1Tov2, v2Tov1)

    bw.append("${if (answer >= Int.MAX_VALUE) -1 else answer}")
    bw.flush()
    bw.close()
}

private fun dijkstra(start: Int, end: Int): Int {
    val distance = IntArray(n + 1) { Int.MAX_VALUE }
    val q = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

    distance[start] = 0
    q.add(start to 0)

    while (q.isNotEmpty()) {
        val (now, dist) = q.poll()

        if (distance[now] < dist) continue

        graph[now].forEach { (b, c) ->
            val cost = dist + c

            if (cost < distance[b]) {
                distance[b] = cost
                q.add(b to cost)
            }
        }
    }

    return distance[end]
}