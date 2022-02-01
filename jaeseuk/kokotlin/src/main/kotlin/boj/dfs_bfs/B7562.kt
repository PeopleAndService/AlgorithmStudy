package boj.dfs_bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private val dx = intArrayOf(-2, -1, 1, 2, 2, 1, -1, -2)
private val dy = intArrayOf(1, 2, 2, 1, -1, -2, -2, -1)

fun main() {
    repeat(br.readLine().toInt()) {
        val i = br.readLine().toInt()
        val board = Array(i) { IntArray(i) }
        val (startX, startY) = br.readLine().split(" ").map { it.toInt() }
        val (endX ,endY) = br.readLine().split(" ").map { it.toInt() }

        bw.append("${bfs(board, startX, startY, endX, endY)}\n")
    }

    bw.flush()
    bw.close()
}

private fun bfs(board: Array<IntArray>, startX: Int, startY: Int, endX: Int, endY: Int): Int {
    val boardRange = board.indices
    val q = LinkedList<Pair<Int, Int>>()
    q.offer(startX to startY)

    while (q.isNotEmpty()) {
        val now = q.poll()

        if (now.first == endX && now.second == endY) break

        repeat(8) {
            val nx = now.first + dx[it]
            val ny = now.second + dy[it]

            if (nx in boardRange &&
                ny in boardRange &&
                board[nx][ny] == 0
            ) {
                board[nx][ny] = board[now.first][now.second] + 1
                q.offer(nx to ny)
            }
        }
    }

    return board[endX][endY]
}