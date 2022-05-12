package baekjoon.topologicalsort_floydwashal

import java.util.*
import kotlin.collections.ArrayList

// 문제집

fun main() {
    val br = System.`in`.bufferedReader()
    val n: Int; val m: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }

    val inDegree = IntArray(n+1)
    val edge = Array (n+1) { ArrayList<Int>() }

    for (i in 0 until m) {
        with(StringTokenizer(br.readLine())) {
            val from = nextToken().toInt(); val to = nextToken().toInt()
            inDegree[to] += 1
            edge[from].add(to)
        }
    }

    println(topologicalSort(inDegree, edge, n))

}

private fun topologicalSort(inDegree: IntArray, edge: Array<ArrayList<Int>>, n: Int): String {
    val queue = PriorityQueue<Int>()
    val stringBuffer = StringBuffer()

    for (i in 1 .. n) {
        if (inDegree[i] == 0) {
            queue.add(i)
        }
    }

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        stringBuffer.append("$current ")

        for (next in edge[current]) {
            if (-- inDegree[next] == 0) {
                queue.add(next)
            }
        }
    }

    return stringBuffer.toString()
}