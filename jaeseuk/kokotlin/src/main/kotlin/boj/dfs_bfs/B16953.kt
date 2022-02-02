package boj.dfs_bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (a, b) = br.readLine().split(" ").map { it.toLong() }

    val q = LinkedList<Pair<Long, Int>>()
    q.offer(a to 0)

    var answer = -1

    while (q.isNotEmpty()) {
        val (value, cnt) = q.poll()

        if (value == b) {
            answer = cnt + 1
            break
        }

        if (value * 2 <= b) q.offer(value * 2 to cnt + 1)
        if (value * 10 + 1 <= b) q.offer(value * 10 + 1 to cnt + 1)
    }

    bw.append("$answer")
    bw.flush()
    bw.close()
}