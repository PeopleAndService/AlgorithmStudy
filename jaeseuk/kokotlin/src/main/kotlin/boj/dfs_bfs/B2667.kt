package boj.dfs_bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private val dx = listOf(1, -1, 0, 0)
private val dy = listOf(0, 0, 1, -1)

val n = br.readLine().toInt()
val map = List<String>(n) { br.readLine() }
val visited = List(n) { MutableList(n) { false } }

fun main() {
    val answer = mutableListOf<Int>()

    for (i in 0..map.lastIndex) {
        for (j in 0..map.lastIndex) {
            if (map[i][j] == '1' && !visited[i][j]) {
                answer.add(dfs(i, j))
            }
        }
    }

    bw.append("${answer.size}\n")
    answer.sorted().forEach { bw.append("$it\n") }

    bw.flush()
    bw.close()
}

private fun dfs(x: Int, y: Int): Int {
    var cnt = 1
    visited[x][y] = true

    dx.zip(dy).forEach { (a, b) ->
        val nx = x + a
        val ny = y + b

        if (nx in 0..map.lastIndex &&
            ny in 0..map.lastIndex &&
            !visited[nx][ny] &&
            map[nx][ny] == '1'
        ) {
            cnt += dfs(nx ,ny)
        }
    }

    return cnt
}