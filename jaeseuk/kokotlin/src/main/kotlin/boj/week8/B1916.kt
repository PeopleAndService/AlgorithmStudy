package boj.week8

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

//  최소비용 구하기

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private var n = br.readLine().toInt()
private var m = br.readLine().toInt()

private val graph = Array<MutableList<Pair<Int, Int>>>(n + 1) { mutableListOf() }
private val distance = IntArray(n + 1) { Int.MAX_VALUE }

private var start = 0
private var end = 0

fun main() {
    repeat(m) {
        StringTokenizer(br.readLine()).run {
            graph[nextToken().toInt()].add(nextToken().toInt() to nextToken().toInt())
        }
    }

    StringTokenizer(br.readLine()).run {
        start = nextToken().toInt()
        end = nextToken().toInt()
    }

    dijkstra()

    bw.append("${distance[end]}")
    bw.flush()
    bw.close()
}

private fun dijkstra() {
    val compareByDistance: Comparator<Pair<Int, Int>> = compareBy { it.second }
    val q = PriorityQueue(compareByDistance)

    distance[start] = 0
    q.add(start to 0)

    while (q.isNotEmpty()) {
        val (now, dist) = q.poll()

        if (distance[now] < dist) continue

        graph[now].forEach { (b, c) ->
            val nd = dist + c

            if (nd < distance[b]) {
                distance[b] = nd
                q.add(b to nd)
            }
        }
    }
}