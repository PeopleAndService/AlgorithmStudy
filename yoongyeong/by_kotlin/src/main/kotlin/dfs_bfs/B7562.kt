package dfs_bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

// 나이트의 이동

private val br = BufferedReader(InputStreamReader(System.`in`))
private val stepX = listOf(1, 1, 2, 2, -1, -1, -2, -2)
private val stepY = listOf(2, -2, 1, -1, 2, -2, 1, -1)

private var mapSize = 0
private lateinit var visited: Array<BooleanArray>
private lateinit var goal: List<Int>

fun main() {
    for (test in 0 until br.readLine()!!.toInt()) {

        mapSize = br.readLine().toInt()
        visited = Array(mapSize) {BooleanArray(mapSize)}
        val curPoint = br.readLine().split(" ").map { it.toInt() }
        goal = br.readLine().split(" ").map { it.toInt() }

        println(bfs(curPoint[0], curPoint[1]))
    }
}

private fun bfs(x: Int, y: Int) : Int{
    val queue = LinkedList<Triple<Int, Int, Int>>()
    queue.add(Triple(x, y, 0)); visited[x][y] = true

    while (queue.isNotEmpty()) {
        val (cx, cy, route) = queue.poll()

        if (cx == goal[0] && cy == goal[1]) return route

        for (step in 0 until 8) {
            val nx = cx + stepX[step]; val ny = cy + stepY[step]

            if (nx in 0 until mapSize && ny in 0 until mapSize && !visited[nx][ny]) {
                queue.offer(Triple(nx, ny, route+1))
                visited[nx][ny] = true
            }
        }

    }

    return -1
}