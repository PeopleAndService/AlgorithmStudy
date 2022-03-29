package boj.week10

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList

//  선수과목

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val graph = Array<MutableList<Int>>(n + 1) { mutableListOf() }
    val inDegree = IntArray(n + 1)
    val visited = BooleanArray(n + 1)

    val q = LinkedList<Pair<Int, Int>>()

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }

        graph[a].add(b)
        inDegree[b]++
    }

    for (i in 1..n) {
        if (inDegree[i] == 0) q.add(i to 1)
    }

    val answer = IntArray(n + 1)

    while (q.isNotEmpty()) {
        val (now, cnt) = q.poll()

        visited[now] = true
        answer[now] = maxOf(answer[now], cnt)

        graph[now].forEach {
            if (--inDegree[it] == 0) q.add(it to cnt + 1)
        }
    }

    bw.append(answer.drop(1).joinToString(" "))
    bw.flush()
    bw.close()
}