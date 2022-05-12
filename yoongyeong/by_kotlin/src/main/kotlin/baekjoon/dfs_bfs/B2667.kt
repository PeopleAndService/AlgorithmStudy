package baekjoon.dfs_bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

// 단지 번호 붙이기

private val br = BufferedReader(InputStreamReader(System.`in`))
private val n = br.readLine().toInt()
private var graph = arrayOf<BooleanArray>()
private val steps = listOf(Pair(0, 1), Pair(1, 0), Pair(0, -1),Pair(-1, 0))

fun main() {
    graph = Array(n) { br.readLine().map { it == '1' }.toBooleanArray() }
    val answer = mutableListOf<Int>()

    for (x in 0 until n) {
        for (y in 0 until n) {
            if (graph[x][y]) {
                answer.add(bfs(x to y))
            }
        }
    }

    print("${answer.size}\n${answer.sorted().joinToString("\n")}")
}

private fun bfs(point: Pair<Int, Int>): Int {
    val list = LinkedList<Pair<Int, Int>>()
    var answer = 1
    list.add(point); graph[point.first][point.second] = false

    while (list.isNotEmpty()) {
        val curPoint = list.poll()
        for (step in steps) {
            val newPoint = curPoint.first + step.first to curPoint.second + step.second
            if (newPoint.first in 0 until n
                && newPoint.second in 0 until n
                && graph[newPoint.first][newPoint.second]) {
                list.add(newPoint); answer += 1
                graph[newPoint.first][newPoint.second] = false
            }
        }
    }

    return answer
}