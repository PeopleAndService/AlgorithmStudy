package week8

import java.util.PriorityQueue
import java.util.StringTokenizer

/*
플랫폼 : 백준
문제번호 : 1261
문제제목 : 알고스팟
난이도 : 골드 4
제한사항 : 1초/128MB
알고리즘 분류 : 그래프 이론, 다익스트라, 0-1 BFS

알고리즘 설명
간선의 가중치가 0과 1로 이루어진 그래프라고 생각하고 다익스트라를 돌린다.

같은 방식으로 0-1 BFS 사용 가능 -> queue 대신 deque를 사용 (0이면 앞에 넣고 1이면 뒤에 넣음)

채점 결과 : 176ms/16968KB
풀이 날짜 : 2022/03/12
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private val dr = intArrayOf(1, 0, -1, 0)
private val dc = intArrayOf(0, 1, 0, -1)

private const val MAX = 100_000

fun main() {
    val (m, n) = with(StringTokenizer(br.readLine())) { IntArray(2) { nextToken().toInt() } }
    val graph = Array(n) { br.readLine().map { it - '0' }.toIntArray() }

    val dist = Array(n) { IntArray(m) { MAX } }
    dist[0][0] = 0
    val queue = PriorityQueue<Edge>(compareBy { it.cost })
    queue.offer(Edge(0, 0, 0))

    while (queue.isNotEmpty()) {
        val (r, c, cost) = queue.poll()

        if (dist[r][c] < cost) continue

        repeat(4) {
            val nr = r + dr[it]
            val nc = c + dc[it]
            if (nr in 0 until n && nc in 0 until m) {
                val temp = cost + graph[r][c]
                if (dist[nr][nc] > temp) {
                    dist[nr][nc] = temp
                    queue.offer(Edge(nr, nc, temp))
                }
            }
        }
    }

    bw.write("${dist[n-1][m-1]}")
    bw.close()
    br.close()
}

private data class Edge(
    val r: Int,
    val c: Int,
    val cost: Int
)