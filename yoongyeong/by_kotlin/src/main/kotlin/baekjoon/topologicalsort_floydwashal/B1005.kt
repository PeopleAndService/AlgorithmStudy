package baekjoon.topologicalsort_floydwashal

import java.util.LinkedList
import java.util.StringTokenizer

// ACM Craft

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    repeat(br.readLine().toInt()) {
        val n: Int; val k: Int
        with(StringTokenizer(br.readLine())) {
            n = nextToken().toInt()
            k = nextToken().toInt()
        }
        val d = IntArray(n+1)
        val graph = Array(n+1) { mutableListOf<Int>() }
        val inDegree = IntArray(n+1)

        with(StringTokenizer(br.readLine())) {
            repeat(n) {
                d[it+1] = nextToken().toInt()
            }
        }

        for (i in 0 until k) {
            with(StringTokenizer(br.readLine())) {
                val a = nextToken().toInt()
                val b = nextToken().toInt()
                graph[a].add(b)
                inDegree[b]++
            }
        }

        val queue = LinkedList<Int>()
        val result = d.clone()

        for (i in 1 .. n) {
            if (inDegree[i] == 0) queue.offer(i)
        }

        while (queue.isNotEmpty()) {
            val current = queue.poll()

            for (next in graph[current]) {
                result[next] = maxOf(result[next], result[current] + d[next])
                inDegree[next] --

                if (inDegree[next] == 0) queue.offer(next)
            }
        }

        bw.write("${result[br.readLine().toInt()]}\n")
    }

    bw.close()
    br.close()
}
