package week8

import java.util.PriorityQueue
import java.util.StringTokenizer

/*
플랫폼 : 백준
문제번호 : 2211
문제제목 : 네트워크 복구
난이도 : 골드 2
제한사항 : 2초/192MB
알고리즘 분류 : 그래프 이론, 다익스트라

알고리즘 설명
다익스트라 알고리즘 사용
중간에 복구한 회선에 대한 정보 저장 후 사용

채점 결과 : 652ms/92896KB
풀이 날짜 : 2022/03/10
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val inst = with(StringTokenizer(br.readLine())) {
        B2211(nextToken().toInt(), nextToken().toInt())
    }
    inst.input()
    val network = inst.dijkstra()
    inst.print(network)
    bw.flush()
    bw.close()
    br.close()
}

class B2211(private val n: Int, private val m: Int) {
    companion object {
        private const val MAX = 1_000_000_000
    }

    data class Edge(val to: Int, val time: Int)

    private val graph = Array(n + 1) { mutableListOf<Edge>() }

    fun input() {
        repeat(m) {
            with(StringTokenizer(br.readLine())) {
                val from = nextToken().toInt()
                val to = nextToken().toInt()
                val time = nextToken().toInt()

                graph[from].add(Edge(to, time))
                graph[to].add(Edge(from, time))
            }
        }
    }

    fun dijkstra(): IntArray {
        val dist = IntArray(n+1) { MAX }
        val network = IntArray(n+1)
        val queue = PriorityQueue<Edge>(compareBy { it.time })
        dist[1] = 0
        queue.offer(Edge(1, 0))

        while (queue.isNotEmpty()) {
            val (curTo, curTime) = queue.poll()

            if (curTime > dist[curTo]) continue
            for ((next, nextTime) in graph[curTo]) {
                val temp = curTime + nextTime
                if (dist[next] > temp) {
                    dist[next] = temp
                    network[next] = curTo
                    queue.offer(Edge(next, dist[next]))
                }
            }
        }

        return network
    }
    
    fun print(network: IntArray) {
        val sb = StringBuilder()
        var count = 0
        for (computer in 2..n) {
            if (network[computer] != 0) {
                count++
                sb.append("$computer ${network[computer]}\n")
            }
        }
        bw.write("$count\n$sb")
    }
}