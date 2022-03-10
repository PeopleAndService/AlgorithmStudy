package boj.week8

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

//  파티

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m, x) = br.readLine().split(" ").map { it.toInt() }

    val partyDistance = IntArray(n + 1) { Int.MAX_VALUE }
    val distance = IntArray(n + 1) { Int.MAX_VALUE }
    val graph = Array<MutableList<Pair<Int, Int>>>(n + 1) { mutableListOf() }

    repeat(m) {
        val (a, b, t) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(b to t)
    }

    var answer = 0

    dijkstra(partyDistance, graph, x)

    repeat(n) {
        dijkstra(distance, graph, it + 1)
        answer = maxOf(answer, distance[x] + partyDistance[it + 1])
        distance.fill(Int.MAX_VALUE)
    }

    bw.append("$answer")
    bw.flush()
    bw.close()
}

private fun dijkstra(distance: IntArray, graph: Array<MutableList<Pair<Int, Int>>>, x: Int) {
    val compareByTime: Comparator<Pair<Int, Int>> = compareBy { it.second }
    val q = PriorityQueue(compareByTime)
    distance[x] = 0
    q.add(0 to x)

    while (q.isNotEmpty()) {
        val (cost, now) = q.poll()

        if (distance[now] < cost) continue

        graph[now].forEach { (b, t) ->
            val dist = cost + t

            if (dist < distance[b]) {
                distance[b] = dist
                q.add(dist to b)
            }
        }
    }
}