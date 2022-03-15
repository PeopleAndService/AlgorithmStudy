package week8

import java.util.PriorityQueue
import java.util.StringTokenizer

/*
플랫폼 : 백준
문제번호 : 1162
문제제목 : 도로포장
난이도 : 골드 1
제한사항 : 2초/128MB
알고리즘 분류 : 그래프 이론, 다익스트라

알고리즘 설명
2차원 배열에 최소 시간 저장
time[i][k] : 해당 정점에 k번의 포장 횟수로 갈 수 있는 최소 시간

채점 결과 : 1020ms/85944KB
풀이 날짜 : 2022/03/13
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n: Int
    val m: Int
    val k: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
        k = nextToken().toInt()
    }

    val graph = Array(n+1) { ArrayList<Triple<Int, Long, Int>>() }.apply {
        repeat(m) {
            with(StringTokenizer(br.readLine())) {
                val a = nextToken().toInt()
                val b = nextToken().toInt()
                val t = nextToken().toLong()
                this@apply[a].add(Triple(b, t, 0))
                this@apply[b].add(Triple(a, t, 0))
            }
        }
    }

    val time = Array(n+1) { LongArray(k+1) { Long.MAX_VALUE } }
    val queue = PriorityQueue<Triple<Int, Long, Int>>(compareBy { it.second })
    queue.offer(Triple(1, 0, 0))
    time[1][0] = 0

    while (queue.isNotEmpty()) {
        val (cur, curTime, curCount) = queue.poll()

        if (curTime > time[cur][curCount]) continue

        for ((next, nextTime) in graph[cur]) {
            val temp = curTime + nextTime
            if (temp < time[next][curCount]) {
                time[next][curCount] = temp
                queue.offer(Triple(next, temp, curCount))
            }
            if (curCount < k && curTime < time[next][curCount + 1]) {
                time[next][curCount + 1] = curTime
                queue.offer(Triple(next, curTime, curCount + 1))
            }
        }
    }

    bw.write("${time[n].minOf { it }}")
    bw.close()
    br.close()
}