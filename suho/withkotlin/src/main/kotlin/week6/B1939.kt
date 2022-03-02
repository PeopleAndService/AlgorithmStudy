package week6

import java.util.StringTokenizer
import kotlin.math.max

/*
플랫폼 : 백준
문제번호 : 1939
문제제목 : 중량제한
난이도 : 골드 4
제한사항 : 1초/128MB
알고리즘 분류 : 그래프 이론, 자료구조, 그래프 탐색, 이분 탐색, 너비 우선 탐색, 분리 집합

알고리즘 설명
구하고자 하는 것은 공장A에서 B로 갈 때, 이동할 수 있는 최대 중량을 찾는 것임
이분 탐색으로 이동할 중량을 찾고(mid), 해당 중량으로 A에서 B로 이동할 수 있는지 bfs로 판단

채점 결과 : 672ms/61064KB
풀이 날짜 : 2022/03/02
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n: Int
    val m: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    val inst = B1939(n, m)
    bw.write("${inst.solution()}")
    bw.close()
    br.close()
}

class B1939(private val n: Int, private val m: Int) {
    private val graph = Array(n+1) { mutableListOf<Edge>() }
    private var start = 1
    private var end = 0

    init {
        input()
    }

    private fun input() {
        repeat(m) {
            with(StringTokenizer(br.readLine())) {
                val a = nextToken().toInt()
                val b = nextToken().toInt()
                val c = nextToken().toInt()
                graph[a].add(Edge(b, c))
                graph[b].add(Edge(a, c))
                end = max(end, c)
            }
        }
    }

    fun solution(): Int {
        val depart: Int
        val arrival: Int
        with(StringTokenizer(br.readLine())) {
            depart = nextToken().toInt()
            arrival = nextToken().toInt()
        }

        var answer = 0
        while (start <= end) {
            val mid = (start + end) / 2

            if (bfs(depart, arrival, mid)) {
                answer = max(answer, mid)
                start = mid + 1
            } else {
                end = mid - 1
            }
        }

        return answer
    }

    private fun bfs(start: Int, end: Int, mid: Int): Boolean {
        val queue = mutableListOf<Int>()
        val visit = BooleanArray(n+1)

        queue.add(start)
        visit[start] = true
        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()

            for ((to, weight) in graph[cur]) {
                if (weight >= mid) {
                    if (cur == end) return true

                    if (!visit[to]) {
                        visit[to] = true
                        queue.add(to)
                    }
                }
            }
        }

        return false
    }

    data class Edge(val to: Int, val weight: Int)
}

