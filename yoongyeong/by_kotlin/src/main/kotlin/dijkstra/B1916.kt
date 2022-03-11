package dijkstra

import java.util.PriorityQueue
import java.util.StringTokenizer

// 최소비용 구하기

private val br = System.`in`.bufferedReader()
private val n = br.readLine().toInt()
private val m = br.readLine().toInt()

fun main() {
    val cities = Array<MutableList<Pair<Int, Int>>>(n + 1){ mutableListOf() }
    repeat(m) {
        with(StringTokenizer(br.readLine())) {
            val start = nextToken().toInt()
            val end = nextToken().toInt()
            val cost = nextToken().toInt()
            cities[start].add(Pair(end, cost))
        }
    }
    val start: Int; val end: Int
    with(StringTokenizer(br.readLine())) {
        start = nextToken().toInt(); end = nextToken().toInt()
    }
    print(dijkstra(cities, start, end))
}

private fun dijkstra(cities: Array<MutableList<Pair<Int, Int>>>, start: Int, end: Int): Int {
    val costs = IntArray(n + 1) {Int.MAX_VALUE}
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy {it.first})
    pq.offer(Pair(start, 0))

    while (pq.isNotEmpty()) {
        val current = pq.peek().first
        val distance = - pq.poll().second
        if (costs[current] < distance) continue

        for (index in cities[current].indices) {
            val next = cities[current][index].first
            val nextDistance = distance + cities[current][index].second
            if (costs[next] > nextDistance) {
                costs[next] = nextDistance
                pq.add(Pair(next, -nextDistance))
            }
        }
    }

    return costs[end]
}