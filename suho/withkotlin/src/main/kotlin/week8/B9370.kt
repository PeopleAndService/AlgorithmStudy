package week8

import java.util.PriorityQueue
import java.util.StringTokenizer
import kotlin.math.min

/*
플랫폼 : 백준
문제번호 : 9370
문제제목 : 미확인 도착지
난이도 : 골드 2
제한사항 : 3초/256MB
알고리즘 분류 : 그래프 이론, 다익스트라

알고리즘 설명
주석 참고

채점 결과 : 3948ms/311536KB
풀이 날짜 : 2022/03/11
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    repeat(br.readLine().toInt()) {
        val n: Int
        val m: Int
        val t: Int
        val s: Int
        val g: Int
        val h: Int
        with(StringTokenizer(br.readLine())) {
            n = nextToken().toInt()
            m = nextToken().toInt()
            t = nextToken().toInt()
        }
        with(StringTokenizer(br.readLine())) {
            s = nextToken().toInt()
            g = nextToken().toInt()
            h = nextToken().toInt()
        }
        val inst = B9370(n, m, t, s, g, h)
        inst.input()
        bw.write(inst.solution())
        bw.newLine()
    }
    bw.close()
    br.close()
}

private class B9370(
    private val n: Int,
    private val m: Int,
    private val t: Int,
    private val s: Int,
    private val g: Int,
    private val h: Int
) {
    private data class Edge(val to: Int, val length: Int)

    private val graph = Array(n+1) { mutableListOf<Edge>() }

    fun input() {
        repeat(m) {
            with(StringTokenizer(br.readLine())) {
                val a = nextToken().toInt()
                val b = nextToken().toInt()
                val d = nextToken().toInt()

                graph[a].add(Edge(b, d))
                graph[b].add(Edge(a, d))
            }
        }
    }

    fun solution(): String = mutableListOf<Int>().apply {
            repeat(t) {
                val target = br.readLine().toInt()
                val path1 = dijkstra(s, g) + dijkstra(g, h) + dijkstra(h, target) // s -> g -> h -> target
                val path2 = dijkstra(s, h) + dijkstra(h, g) + dijkstra(g, target) // s -> h -> g -> target
                val directPath = dijkstra(s, target) // s -> target

                // 모든 정점간의 도로가 1개이기 때문에 아래 조건식을 만족하면 g-h 도로를 반드시 지난 최단 경로임이 보장
                if (min(path1, path2) == directPath) add(target)
            }
            sort()
        }.joinToString(" ")

    private fun dijkstra(start: Int, end: Int): Int {
        val dist = IntArray(n+1) { 1_000_000_000 }
        val queue = PriorityQueue<Edge>(compareBy { it.length })
        dist[start] = 0
        queue.offer(Edge(start, 0))

        while (queue.isNotEmpty()) {
            val (curTo, curTime) = queue.poll()

            if (curTime > dist[curTo]) continue

            for ((nextTo, nextTime) in graph[curTo]) {
                val temp = curTime + nextTime
                if (dist[nextTo] > temp) {
                    dist[nextTo] = temp
                    queue.offer(Edge(nextTo, temp))
                }
            }
        }

        return dist[end]
    }
}