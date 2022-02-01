package boj.dfs_bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

fun main() {
    val (m, n, k) = br.readLine().split(" ").map { it.toInt() }
    val paper = Array(m) { IntArray(n) }
    val visited = Array(m) { BooleanArray(n) }

    repeat(k) {
        val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toInt() }

        for (i in x1 until x2) {
            for (j in y1 until y2) {
                paper[j][i] = 1
            }
        }
    }

    val answer = ArrayList<Int>()

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (!visited[i][j] && paper[i][j] == 0) answer.add(dfs(paper, visited, i, j))
        }
    }

    answer.sort()

    bw.append("${answer.size}\n")
    bw.append(answer.joinToString(" "))
    bw.flush()
    bw.close()
}

private fun dfs(paper: Array<IntArray>, visited: Array<BooleanArray>, x: Int, y: Int): Int {
    var cnt = 1
    visited[x][y] = true

    repeat(4) {
        val nx = x + dx[it]
        val ny = y + dy[it]

        if (nx in 0..paper.lastIndex &&
            ny in 0..paper[0].lastIndex &&
            !visited[nx][ny] &&
            paper[nx][ny] == 0
        ) {
            cnt += dfs(paper, visited, nx, ny)
        }
    }

    return cnt
}