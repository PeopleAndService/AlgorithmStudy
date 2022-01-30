package boj.dfs_bfs

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private val n = br.readLine().toInt()

private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)

fun main() {
    val picture1 = Array(n) { br.readLine().toCharArray() }
    val picture2 = picture1.map { row -> row.map { col -> if (col == 'G') 'R' else col }.toCharArray() }.toTypedArray()
    val visited1 = Array(n) { BooleanArray(n) { false } }
    val visited2 = Array(n) { BooleanArray(n) { false } }

    var answer1 = 0
    var answer2 = 0

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!visited1[i][j]) {
                answer1++
                dfs(i, j, visited1, picture1)
            }

            if (!visited2[i][j]) {
                answer2++
                dfs(i, j, visited2, picture2)
            }
        }
    }

    bw.write("$answer1 $answer2")
    bw.flush()
    bw.close()
}

private fun dfs(x: Int, y: Int, visited: Array<BooleanArray>, picture: Array<CharArray>) {
    visited[x][y] = true

    dx.zip(dy).forEach { (a, b) ->
        val nx = x + a
        val ny = y + b

        if (nx in 0 until n &&
            ny in 0 until n &&
            !visited[nx][ny] &&
            picture[nx][ny] == picture[x][y]
        ) {
            dfs(nx, ny, visited, picture)
        }
    }
}