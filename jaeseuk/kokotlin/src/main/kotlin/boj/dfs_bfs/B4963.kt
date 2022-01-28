package boj.dfs_bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val dx = listOf(1, 1, 1, -1, -1, -1, 0, 0)
    val dy = listOf(1, -1, 0, 1, -1, 0, 1, -1)

    while (true) {
        val (w, h) = br.readLine().split(" ").map { it.toInt() }

        if (w == 0 && h == 0) break

        val map = List(h) { br.readLine().split(" ") }
        val visited = List(h) { MutableList(w) { false } }

        var cnt = 0

        for (i in 0 until h) {
            for (j in 0 until w) {
                if (!visited[i][j] && map[i][j] == "1") {
                    cnt++
                    dfs(map, visited, dx, dy, i, j)
                }
            }
        }

        bw.write("$cnt\n")
    }

    bw.flush()
    bw.close()
}

private fun dfs(
    map: List<List<String>>,
    visited: List<MutableList<Boolean>>,
    dx: List<Int>,
    dy: List<Int>,
    x: Int,
    y: Int
) {
    visited[x][y] = true

    dx.zip(dy).forEach { (a, b) ->
        val nx = x + a
        val ny = y + b

        if (nx in 0..map.lastIndex &&
            ny in 0..map[nx].lastIndex &&
            !visited[nx][ny] &&
            map[nx][ny] == "1"
        ) {
            dfs(map, visited, dx, dy, nx, ny)
        }
    }
}