package week8

import java.util.*

/*
플랫폼 : 백준
문제번호 : 13911
문제제목 : 집 구하기
난이도 : 골드 2
제한사항 : 1초/256MB
알고리즘 분류 : 그래프 이론, 다익스트라

알고리즘 설명
맥도날드 까지의 최단 경로 배열, 스타벅스 까지의 최단 경로 배열을 다익스트라로 구하고 조건에 맞는 답 구하기

채점 결과 : 1216ms/146172KB
풀이 날짜 : 2022/03/15
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val v: Int
    val e: Int
    with(StringTokenizer(br.readLine())) {
        v = nextToken().toInt()
        e = nextToken().toInt()
    }

    val graph = Array(v + 1) { mutableListOf<Pair<Int, Int>>() }.apply {
        repeat(e) {
            with(StringTokenizer(br.readLine())) {
                val u = nextToken().toInt()
                val v = nextToken().toInt()
                val w = nextToken().toInt()
                this@apply[u].add(v to w)
                this@apply[v].add(u to w)
            }
        }
    }

    val mac = IntArray(v + 1) { Int.MAX_VALUE }
    val star = IntArray(v + 1) { Int.MAX_VALUE }
    val macQ = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    val starQ = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

    val m: Int
    val x: Int
    with(StringTokenizer(br.readLine())) {
        m = nextToken().toInt()
        x = nextToken().toInt()
    }
    with(StringTokenizer(br.readLine())) {
        repeat(m) {
            val mv = nextToken().toInt()
            mac[mv] = 0
            macQ.offer(mv to 0)
        }
    }

    val s: Int
    val y: Int
    with(StringTokenizer(br.readLine())) {
        s = nextToken().toInt()
        y = nextToken().toInt()
    }
    with(StringTokenizer(br.readLine())) {
        repeat(s) {
            val sv = nextToken().toInt()
            star[sv] = 0
            starQ.offer(sv to 0)
        }
    }

    dijkstra(mac, macQ, graph)
    dijkstra(star, starQ, graph)

    val answer = mac.zip(star) { macD, starD ->
        when {
            macD in 1.. x && starD in 1..y -> macD + starD
            else -> Int.MAX_VALUE
        }
    }.minOf { it }

    bw.write("${if (answer == Int.MAX_VALUE) -1 else answer}")
    bw.close()
    br.close()
}

private fun dijkstra(dist: IntArray, queue: PriorityQueue<Pair<Int, Int>>, graph: Array<MutableList<Pair<Int, Int>>>) {
    while (queue.isNotEmpty()) {
        val (cur, curWeight) = queue.poll()

        if (curWeight > dist[cur]) continue

        for ((next, nextWeight) in graph[cur]) {
            val weight = curWeight + nextWeight
            if (weight < dist[next]) {
                dist[next] = weight
                queue.offer(next to weight)
            }
        }
    }
}