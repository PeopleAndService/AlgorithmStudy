package dijkstra

import java.util.PriorityQueue
import java.util.StringTokenizer

// 해킹

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    repeat(br.readLine().toInt()) {
        val n: Int; val d: Int; val c: Int
        with(StringTokenizer(br.readLine())) {
            n = nextToken().toInt(); d = nextToken().toInt(); c = nextToken().toInt()
        }
        val network = Array<MutableList<Pair<Int, Int>>>(n+1) { mutableListOf() }
        repeat(d) {
            with(StringTokenizer(br.readLine())) {
                val a = nextToken().toInt(); val b = nextToken().toInt()
                network[b].add(Pair(a, nextToken().toInt()))
            }
        }
        bw.write("${dijkstra(n, c, network)}\n")
    }
    bw.flush(); bw.close(); br.close()
}

private fun dijkstra(n: Int, start: Int, network: Array<MutableList<Pair<Int, Int>>>) : String{
    val cost = IntArray(n+1) {Int.MAX_VALUE}
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
    pq.add(Pair(start, 0)); cost[start] = 0

    while (pq.isNotEmpty()) {
        val (current, distance) = pq.poll()
        if (cost[current] < distance) continue

        for (index in network[current].indices) {
            val next = network[current][index].first
            val nextDistance = network[current][index].second + distance
            if (cost[next] > nextDistance) {
                cost[next] = nextDistance
                pq.add(Pair(next, nextDistance))
            }
        }
    }

    return "${cost.count { it != Int.MAX_VALUE }} ${cost.maxOfOrNull { if (it == Int.MAX_VALUE) 0 else it }}"
}