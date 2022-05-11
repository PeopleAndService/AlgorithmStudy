package baekjoon.dijkstra

import java.util.PriorityQueue
import java.util.StringTokenizer

// 집구하기

private lateinit var seoul: Array<MutableList<Pair<Int, Int>>>
private var v = 0; private var e = 0

fun main() {
    val br = System.`in`.bufferedReader()

    with(StringTokenizer(br.readLine())) {
        v = nextToken().toInt(); e = nextToken().toInt()
    }
    seoul = Array(v+3) { mutableListOf() }
    repeat(e) {
        with(StringTokenizer(br.readLine())) {
            val u = nextToken().toInt(); val vv = nextToken().toInt(); val w = nextToken().toInt()
            seoul[u].add(Pair(vv, w))
            seoul[vv].add(Pair(u, w))
        }
    }

    // 맥도날드
    val mcdonaldCnt: Int; val mcdonaldMinimumDistance: Int; val mcdonaldNode = v+1
    with(StringTokenizer(br.readLine())) {
        mcdonaldCnt = nextToken().toInt(); mcdonaldMinimumDistance = nextToken().toInt()
    }
    with(StringTokenizer(br.readLine())) {
        repeat(mcdonaldCnt) {
            val mcdonald = nextToken().toInt()
            seoul[mcdonald].add(Pair(mcdonaldNode, 0))
            seoul[mcdonaldNode].add(Pair(mcdonald, 0))
        }
    }

    val mcdonaldDistance = dijkstra(mcdonaldNode)

    // 스타벅스
    val starbucksCnt: Int; val starbucksMinimumDistance: Int; val starbucksNode = v+2
    with(StringTokenizer(br.readLine())) {
        starbucksCnt = nextToken().toInt(); starbucksMinimumDistance = nextToken().toInt()
    }
    with(StringTokenizer(br.readLine())) {
        repeat(starbucksCnt) {
            val starbucks = nextToken().toInt()
            seoul[starbucks].add(Pair(starbucksNode, 0))
            seoul[starbucksNode].add(Pair(starbucks, 0))
        }
    }

    val starbucksDistance = dijkstra(starbucksNode)

    var answer = Int.MAX_VALUE
    for (i in 1 .. v) {
        if (mcdonaldDistance[i] in 1 .. mcdonaldMinimumDistance && starbucksDistance[i] in 1.. starbucksMinimumDistance) {
            answer = minOf(answer, mcdonaldDistance[i] + starbucksDistance[i])
        }
    }

    print(if (answer == Int.MAX_VALUE) -1 else answer )
}

private fun dijkstra(start: Int): IntArray {
    val distances = IntArray(v+3) { Int.MAX_VALUE }
    val pq = PriorityQueue<Pair<Int, Int>> (compareBy { it.second })
    pq.add(Pair(start, 0)); distances[start] = 0

    while (pq.isNotEmpty()) {
        val (current, distance) = pq.poll()

        if (distances[current] < distance) continue

        seoul[current].forEach { (next, nextDistance) ->
            if (next !in v+1 .. v+2) {
                (nextDistance + distance).run {
                    if (this < distances[next]) {
                        distances[next] = this
                        pq.add(Pair(next, this))
                    }
                }
            }

        }
    }

    return distances
}