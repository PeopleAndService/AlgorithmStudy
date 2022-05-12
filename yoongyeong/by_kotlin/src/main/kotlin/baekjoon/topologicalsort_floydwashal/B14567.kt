package baekjoon.topologicalsort_floydwashal

import java.util.LinkedList
import java.util.StringTokenizer

// 선수과목

fun main() {
    val br = System.`in`.bufferedReader()
    val n: Int; val m: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt(); m = nextToken().toInt()
    }

    val graph = Array(n+1) { mutableListOf<Int>() }
    val inDegree = IntArray(n+1)
    val visited = BooleanArray(n+1)
    val answer = IntArray(n+1)

    val queue = LinkedList<Pair<Int, Int>>()

    repeat(m) {
        with(StringTokenizer(br.readLine())) {
            val a = nextToken().toInt()
            val b = nextToken().toInt()
            graph[a].add(b)
            inDegree[b]++
        }
    }

    for (index in 1 .. n) {
        if (inDegree[index] == 0) queue.add(Pair(index, 1))
    }

    while (queue.isNotEmpty()) {
        val (current, cnt) = queue.poll()

        visited[current] = true
        answer[current] = maxOf(answer[current], cnt)

        graph[current].forEach {
            if (--inDegree[it] == 0) queue.add(Pair(it, cnt+1))
        }
    }

    print(answer.drop(1).joinToString(" "))
}