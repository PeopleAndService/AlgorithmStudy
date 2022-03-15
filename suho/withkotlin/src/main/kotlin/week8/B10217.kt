package week8

import java.util.*
import kotlin.math.min

/*
플랫폼 : 백준
문제번호 : 10217
문제제목 : KCM Travel
난이도 : 플래티넘 5
제한사항 : 10초/256MB
알고리즘 분류 : 그래프 이론, 다익스트라, DP

알고리즘 설명
2차원 dp 배열에 지원 비용으로 갈 수 있는 최소 시간 저장
dp[i][m] = i 공항까지 m비용으로 갈 수 있는 최소 시간

채점 결과 : 6636ms/112760KB
풀이 날짜 : 2022/03/14
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    repeat(br.readLine().toInt()) {
        val n: Int
        val m: Int
        val k: Int
        with(StringTokenizer(br.readLine())) {
            n = nextToken().toInt()
            m = nextToken().toInt()
            k = nextToken().toInt()
        }

        val graph = Array(n + 1) { mutableListOf<Triple<Int, Int, Int>>() }.apply {
            repeat(k) {
                with(StringTokenizer(br.readLine())) {
                    val u = nextToken().toInt()
                    val v = nextToken().toInt()
                    val c = nextToken().toInt()
                    val d = nextToken().toInt()
                    this@apply[u].add(Triple(v, c, d))
                }
            }
        }

        val dp = Array(n + 1) { IntArray(m + 1) { Int.MAX_VALUE } }
        val queue = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.third }) // 공항, 비용, 시간
        queue.offer(Triple(1, 0, 0))
        dp[1][0] = 0

        while (queue.isNotEmpty()) {
            val (cur, curCost, curTime) = queue.poll()

            if (cur == n) break
            if (curTime > dp[cur][curCost]) continue
            dp[cur][curCost] = curTime

            for ((next, nextCost, nextTime) in graph[cur]) {
                val cost = curCost + nextCost
                if (cost > m) continue

                val time = curTime + nextTime
                if (time < dp[next][cost]) {
                    for (c in cost..m) {
                        dp[next][c] = min(dp[next][c], time)
                    }
                    queue.add(Triple(next, cost, time))
                }
            }
        }

        val answer = dp[n].minOrNull()?.let { if (it == Int.MAX_VALUE) "Poor KCM" else "$it" } ?: "Poor KCM"
        bw.write(answer)
        bw.newLine()
    }
    bw.close()
    br.close()
}