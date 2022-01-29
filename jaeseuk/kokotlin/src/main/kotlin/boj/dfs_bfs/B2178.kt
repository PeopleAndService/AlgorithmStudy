package boj.dfs_bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val dx = listOf(0, -1, 1, 0)
    val dy = listOf(1, 0, 0, -1)

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val maze = List(n) { br.readLine() }
    val visited = List(n) { MutableList(m) { false } }

    val q: Queue<Triple<Int, Int, Int>> = LinkedList()
    q.offer(Triple(0, 0, 1))
    visited[0][0] = true

    while (q.isNotEmpty()) {
        val (x, y, cnt) = q.poll()

        if (x == n -1 && y == m - 1) {
            bw.write("$cnt")
            bw.flush()
            bw.close()
            return
        }

        dx.zip(dy).forEach { (a, b) ->
            val nx = x + a
            val ny = y + b

            if (nx in 0 until n &&
                ny in 0 until m &&
                !visited[nx][ny] &&
                maze[nx][ny] == '1'
            ) {
                visited[nx][ny] = true
                q.offer(Triple(nx, ny, cnt + 1))
            }
        }
    }
}