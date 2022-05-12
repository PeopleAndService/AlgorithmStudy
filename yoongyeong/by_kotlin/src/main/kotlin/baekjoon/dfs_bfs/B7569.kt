package baekjoon.dfs_bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

// 토마토

private val br = BufferedReader(InputStreamReader(System.`in`))
private val mnh = br.readLine().split(" ").map { it.toInt() }
private val boxes = Array(mnh[2]) {Array(mnh[1]) {IntArray(mnh[0])} }
private var cnt = 0
private val stepX = listOf(0, 1, 0, -1, 0, 0)
private val stepY = listOf(1, 0, -1, 0, 0, 0)
private val stepZ = listOf(0, 0, 0, 0, 1, -1)

private val queue = LinkedList<Triple<Int, Int, Int>> ()

fun main() {
    for (h in 0 until mnh[2]) {
        for (r in 0 until mnh[1]) {
            br.readLine().split(" ").forEachIndexed {index, state ->
                boxes[h][r][index] = state.toInt()
                if (state == "1") queue.add(Triple(h, r, index))
                if (state != "0") cnt += 1
            }
        }
    }

    val year = bfs()
    if (cnt == mnh[0]*mnh[1]* mnh[2]) print(year)
    else print(-1)
}


private fun bfs() : Int {
    var year = -1

    while (queue.isNotEmpty()) {
        year += 1
        for (i in 0 until queue.size) {
            val (h, r, c) = queue.poll()
            for (step in 0 until 6) {
                val newTomato = Triple(h+ stepZ[step], r+stepX[step], c+stepY[step])
                if (newTomato.first in 0 until mnh[2]
                    && newTomato.second in 0 until mnh[1]
                    && newTomato.third in 0 until mnh[0]
                    && boxes[newTomato.first][newTomato.second][newTomato.third] == 0) {
                    queue.add(newTomato)
                    boxes[newTomato.first][newTomato.second][newTomato.third] = 1
                    cnt += 1
                }
            }
        }
    }

    return year
}