package boj.week10

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList

//  줄 세우기

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array<MutableList<Int>>(n + 1) { mutableListOf() }
    val inDegree = IntArray(n + 1)

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }

        inDegree[b]++
        graph[a].add(b)
    }

    val q = LinkedList<Int>()

    for (i in 1..n) {
        if (inDegree[i] == 0) q.add(i)
    }

    while (q.isNotEmpty()) {
        val now = q.poll()
        bw.write("$now ")

        graph[now].forEach {
            if (--inDegree[it] == 0) q.add(it)
        }
    }

    bw.flush()
    bw.close()
}