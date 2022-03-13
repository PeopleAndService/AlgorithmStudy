package boj.week8

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

//  숨바꼭질 3

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private var n = 0
private var k = 0

private var maxPoint = 0

private lateinit var distance: IntArray

fun main() {
    StringTokenizer(br.readLine()).run {
        n = nextToken().toInt()
        k = nextToken().toInt()
    }

    maxPoint = maxOf(n, k) * 2
    distance = IntArray(maxPoint) { Int.MAX_VALUE }

    dijkstra()

    bw.append("${distance[k]}")
    bw.flush()
    bw.close()
}

private fun dijkstra() {
    val q = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

    distance[n] = 0
    q.add(n to 0)

    while (q.isNotEmpty()) {
        val (now, dist) = q.poll()

        if (distance[now] < dist) continue

        if (now != 0) setMinCost(dist + 1, now - 1, q)
        if (now < maxPoint - 1) setMinCost(dist + 1, now + 1, q)
        if (now * 2 < maxPoint) setMinCost(dist, now * 2, q)


    }
}

private fun setMinCost(cost: Int, t: Int, q: PriorityQueue<Pair<Int, Int>>) {
    if (cost < distance[t]) {
        distance[t] = cost
        q.add(t to cost)
    }
}