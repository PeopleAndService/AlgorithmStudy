package week8

import java.util.PriorityQueue
import java.util.StringTokenizer

/*
플랫폼 : 백준
문제번호 : 10282
문제제목 : 해킹
난이도 : 골드 4
제한사항 : 2초/256MB
알고리즘 분류 : 그래프 이론, 다익스트라

알고리즘 설명
다익스트라 알고리즘으로 컴퓨터의 감염을 구현
양방향 관계가 아니라 b -> a의 단방향 관계임에 유의

채점 결과 : 1296ms/177384KB
풀이 날짜 : 2022/03/13
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    repeat(br.readLine().toInt()) {
        val n: Int
        val d: Int
        val c: Int
        with(StringTokenizer(br.readLine())) {
            n = nextToken().toInt()
            d = nextToken().toInt()
            c = nextToken().toInt()
        }
        val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }.apply {
            repeat(d) {
                with(StringTokenizer(br.readLine())) {
                    val a = nextToken().toInt()
                    val b = nextToken().toInt()
                    val s = nextToken().toInt()
                    this@apply[b].add(a to s)
                }
            }
        }
        val time = IntArray(n + 1) { Int.MAX_VALUE }
        val queue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        queue.offer(c to 0)
        time[c] = 0

        while (queue.isNotEmpty()) {
            val (cur, curTime) = queue.poll()

            if (curTime > time[cur]) continue

            graph[cur].forEach { (next, nextTime) ->
                val temp = curTime + nextTime
                if (temp < time[next]) {
                    time[next] = temp
                    queue.offer(next to temp)
                }
            }
        }

        bw.write("${time.count { it != Int.MAX_VALUE }} ${time.maxOf { if (it == Int.MAX_VALUE) 0 else it }}")
        bw.newLine()
    }
    bw.close()
    br.close()
}