package baekjoon.dfs_bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

// 미로 탐색

private val br = BufferedReader(InputStreamReader(System.`in`))
private val nm = br.readLine().split(" ").map { it.toInt() }
private val maze = Array(nm[0]) { br.readLine().map { it.toString().toInt() }.toIntArray() }
private val visited = Array(nm[0]) {BooleanArray(nm[1])}
private val steps = listOf(Pair(0, 1), Pair(1, 0), Pair(0, -1),Pair(-1, 0))


fun main() {
    bfs(0 to 0)
    print(maze[nm[0]-1][nm[1]-1])
}

private fun bfs(point: Pair<Int, Int>) {
    visited[point.first][point.second] = true
    val list = LinkedList<Pair<Int, Int>> ()
    list.add(point)

    while (list.isNotEmpty()) {
        val curPoint = list.poll()
        for (step in steps) {
            val newPoint = curPoint.first + step.first to curPoint.second + step.second
            if (newPoint.first in 0 until nm[0]
                && newPoint.second in 0 until nm[1]
                && !visited[newPoint.first][newPoint.second]
                && maze[newPoint.first][newPoint.second] != 0) {
                list.add(newPoint)
                maze[newPoint.first][newPoint.second] = maze[curPoint.first][curPoint.second] + 1
                visited[newPoint.first][newPoint.second] = true
            }
        }
    }
}