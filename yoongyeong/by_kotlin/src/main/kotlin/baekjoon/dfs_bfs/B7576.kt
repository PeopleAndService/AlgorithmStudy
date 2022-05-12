package baekjoon.dfs_bfs

import java.io.BufferedReader
import java.io.InputStreamReader

// 토마토

private val br = BufferedReader(InputStreamReader(System.`in`))
private val nm = br.readLine().split(" ").map { it.toInt() }
private val boxes = Array(nm[1]) {IntArray(nm[0])}
private var tomatoes = mutableListOf<Pair<Int, Int>>()
private var cnt = 0
private val stepX = listOf(0, 1, 0, -1)
private val stepY = listOf(1, 0, -1, 0)

fun main() {
    for (i in 0 until nm[1]) {
        br.readLine().split(" ").forEachIndexed {index, state ->
            boxes[i][index] = state.toInt()
            if (state == "1") tomatoes.add(Pair(i, index))
            if (state != "0") cnt += 1
        }
    }

    for (year in 0 .. nm[0] * nm[1]) {
        val newTomatoes = mutableListOf<Pair<Int, Int>>()

        for (tomato in tomatoes) {
            for (step in 0 until 4) {
                val newTomato = Pair(tomato.first+stepX[step], tomato.second+stepY[step])
                if (newTomato.first in 0 until nm[1]
                    && newTomato.second in 0 until nm[0]
                    && boxes[newTomato.first][newTomato.second] == 0) {
                    newTomatoes.add(newTomato)
                    boxes[newTomato.first][newTomato.second] = 1
                    cnt += 1
                }
            }
        }

        if (newTomatoes.isEmpty() && cnt == nm[0] * nm[1]) {
            print(year); return
        } else if (newTomatoes.isEmpty()) {
            print(-1); return
        }

        tomatoes = newTomatoes
    }

    print(nm[0] * nm[1])
}