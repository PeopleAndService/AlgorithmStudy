package boj.week10

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

//  작업

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()

    val graph = Array<MutableList<Int>>(n + 1) { mutableListOf() }
    val inDegree = IntArray(n + 1)
    val times = IntArray(n + 1)

    var answer = 0
    val q = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

    for (i in 1..n) {
        with(StringTokenizer(br.readLine())) {
            val time = nextToken().toInt()
            val works = nextToken().toInt()

            times[i] = time
            inDegree[i] = works

            repeat(works) {
                graph[nextToken().toInt()].add(i)
            }

            if (works == 0) q.add(i to time)
        }
    }

    while (q.isNotEmpty()) {
        val (work, total) = q.poll()

        answer = maxOf(answer, total)

        graph[work].forEach {
            if (--inDegree[it] == 0) q.add(it to total + times[it])
        }
    }

    bw.write("$answer")
    bw.flush()
    bw.close()
}