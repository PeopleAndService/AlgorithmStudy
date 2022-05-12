package baekjoon.simulation_greedy

import java.util.*

// 미세먼지 안녕!

private var airCleaner = -1
private var stepR = listOf(0, 0, 1, -1)
private var stepC = listOf(1, -1, 0, 0)

fun main() {
    val br = System.`in`.bufferedReader()
    val (r, c, time) = br.readLine().split(" ").map { it.toInt() }
    var map = Array(r) {StringTokenizer(br.readLine()).run { IntArray(c) {nextToken().toInt()} }}

    repeat(time) {
        val nMap = Array(r) {IntArray(c)}

        // 미세먼지 확산
        for (row in 0 until r) {
            for (col in 0 until c) {
                if (airCleaner == -1 && map[row][col] == -1)  airCleaner = row

                if (map[row][col] > 0) {
                    var cnt = 0; val dust = map[row][col] / 5

                    for (step in 0 until 4) {
                        val nRow = row + stepR[step]; val nCol = col + stepC[step]

                        if (nRow in 0 until r && nCol in 0 until c && map[nRow][nCol] != -1) {
                            nMap[nRow][nCol] += dust
                            cnt++
                        }
                    }
                    nMap[row][col] += map[row][col] - dust * cnt
                }
            }
        }
        nMap[airCleaner][0] = -1; nMap[airCleaner+1][0] = -1

        // 공기청정기 작동 (윗부분)
        for (row in airCleaner - 1 downTo 1) nMap[row][0] = nMap[row-1][0]
        for (col in 0 until c -1) nMap[0][col] = nMap[0][col+1]
        for (row in 0 until  airCleaner) nMap[row][c-1] = nMap[row+1][c-1]
        for (col in c - 1 downTo 2) nMap[airCleaner][col] = nMap[airCleaner][col-1]
        nMap[airCleaner][1] = 0

        // 공기청정기 작동 (아랫부분)
        for (row in airCleaner + 2 until r - 1) nMap[row][0] = nMap[row + 1][0]
        for (col in 0 until c - 1) nMap[r-1][col] = nMap[r-1][col+1]
        for (row in r-1 downTo  airCleaner+2) nMap[row][c-1] = nMap[row-1][c-1]
        for (col in c-1 downTo 2) nMap[airCleaner+1][col] = nMap[airCleaner+1][col-1]
        nMap[airCleaner+1][1] = 0

        map = nMap
    }

    var result = 2
    for (i in 0 until r) result += map[i].sum()

    print(result)
}