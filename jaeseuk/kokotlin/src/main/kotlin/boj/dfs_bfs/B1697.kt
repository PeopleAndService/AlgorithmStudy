package boj.dfs_bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val visited = BooleanArray(200000) { false }

    val q = LinkedList<Pair<Int, Int>>()
    q.offer(n to 0)

    while (q.isNotEmpty()) {
        val (now, time) = q.poll()
        visited[now] = true

        if (now == k) {
            bw.write("$time")
            bw.flush()
            bw.close()
            break
        }

        if (now < k) {
            if (!visited[now + 1]) q.offer(now + 1 to time + 1)
            if (!visited[now * 2]) q.offer(now * 2 to time + 1)
        }

        if (now > 0 && !visited[now - 1]) {
            q.offer(now - 1 to time + 1)
        }
    }
}