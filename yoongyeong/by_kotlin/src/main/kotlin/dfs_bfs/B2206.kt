package dfs_bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

// 벽 부수고 이동하기

private val br = BufferedReader(InputStreamReader(System.`in`))
private val nm = br.readLine().split(" ").map { it.toInt() }
private val graph = Array(nm[0]) {br.readLine().map { it.toInt()-'0'.toInt() }}
private val visited = Array(nm[0]) { Array(nm[1]) {Array(2) {0} } }
private val stepX = listOf(0, 1, 0, -1)
private val stepY = listOf(1, 0, -1, 0)

fun main() {
    print(bfs())
}

private fun bfs(): Int {
    val queue = LinkedList<Triple<Int, Int, Int>>()

    queue.offer(Triple(0, 0, 1)); visited[0][0][1] = 1

    while (queue.isNotEmpty()) {
        val (x, y, broken) = queue.poll()

        if (x == nm[0]-1 && y == nm[1]-1) return visited[x][y][broken]

        for (step in 0 until 4) {
            val newPointX = x+ stepX[step]; val newPointY = y+ stepY[step]

            if (newPointX in 0 until nm[0] && newPointY in 0 until nm[1]) {

                if (graph[newPointX][newPointY] == 1 && broken == 1) {
                    queue.offer(Triple(newPointX, newPointY, 0))
                    visited[newPointX][newPointY][0] = visited[x][y][1] + 1
                }

                if (graph[newPointX][newPointY] == 0 && visited[newPointX][newPointY][broken] == 0) {
                    queue.add(Triple(newPointX, newPointY, broken))
                    visited[newPointX][newPointY][broken] = visited[x][y][broken] + 1
                }
            }
        }
    }

    return -1
}