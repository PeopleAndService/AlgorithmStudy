package boj.dfs_bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    val (m, n) = br.readLine().split(" ").map { it.toInt() }

    var cnt = 0
    val q = LinkedList<Triple<Int, Int, Int>>()

    val box = Array(n) { x ->
        br.readLine().split(" ").toTypedArray().also {
            it.forEachIndexed { y, s ->
                if (s == "1") q.offer(Triple(x, y, 0))
                if (s != "-1") cnt++
            }
        }
    }

    var answer = -1

    while (q.isNotEmpty()) {
        val (x, y, d) = q.poll()
        cnt--

        if (cnt == 0) {
            answer = d
            break
        }

        repeat(4) {
            val nx = x + dx[it]
            val ny = y + dy[it]

            if (nx in 0 until n && ny in 0 until m && box[nx][ny] == "0") {
                box[nx][ny] = "1"
                q.offer(Triple(nx, ny, d + 1))
            }
        }
    }

    bw.append("$answer")
    bw.flush()
    bw.close()
}