package boj.week9

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue
import java.util.StringTokenizer

//  행성 연결

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private val n = br.readLine().toInt()

private val graph = Array(n) { StringTokenizer(br.readLine()).run { LongArray(n) { nextToken().toLong() } } }

fun main() {
    bw.append("${prim()}")
    bw.flush()
    bw.close()
}

private fun prim(): Long {
    val q = PriorityQueue<Pair<Long,  Int>>(compareBy { it.first })
    val visited = BooleanArray(n)

    var answer = 0L

    q.add(0L to 0)

    while (q.isNotEmpty()) {
        val (cost, now) = q.poll()

        if (!visited[now]) {
            visited[now] = true
            answer += cost

            repeat(n) {
                if (graph[now][it] != 0L && !visited[it]) q.add(graph[now][it] to it)
            }
        }
    }

    return answer
}