package boj.week8

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

//  택배 배송

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array<MutableList<Pair<Int, Int>>>(n + 1) { mutableListOf() }

    repeat(m) {
        StringTokenizer(br.readLine()).run {
            val a = nextToken().toInt()
            val b = nextToken().toInt()
            val c = nextToken().toInt()

            graph[a].add(b to c)
            graph[b].add(a to c)
        }
    }

    bw.append("${dijkstra(n, graph)}")
    bw.flush()
    bw.close()
}

private fun dijkstra(n: Int, graph: Array<MutableList<Pair<Int, Int>>>): Int {
    val distance = IntArray(n + 1) { Int.MAX_VALUE }
    val q = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

    distance[1] = 0
    q.add(1 to 0)

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

    return distance[n]
}