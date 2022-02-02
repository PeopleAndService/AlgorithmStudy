package week2

import java.util.*

/*
플랫폼 : 백준
문제번호 : 4963
문제제목 : 섬의 개수
난이도 : 실버 2
제한사항 : 1초/128MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, BFS, DFS

알고리즘 설명
1. DFS의 엔트리포인트 카운트

채점 결과 : 180ms/18936KB
풀이 날짜 : 2022/02/01
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private val dr = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
private val dc = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)

private var w = 0
private var h = 0
private lateinit var rowRange: IntRange
private lateinit var colRange: IntRange

private lateinit var map: Array<IntArray>
private lateinit var visit: Array<BooleanArray>

fun main() {
    while (true) {
        StringTokenizer(br.readLine()).run {
            w = nextToken().toInt()
            h = nextToken().toInt()
            rowRange = 0 until h
            colRange = 0 until w
        }
        if (w == 0 && h == 0) break
        map = Array(h) {
            StringTokenizer(br.readLine()).run {
                IntArray(w) { nextToken().toInt() }
            }
        }

        bw.write("${check()}\n")
    }

    bw.close()
    br.close()
}

private fun check(): Int {
    visit = Array(h) { BooleanArray(w) }
    var count = 0
    repeat(h) { row ->
        repeat(w) { col ->
            if (map[row][col] == 1 && !visit[row][col]) {
                visit[row][col] = true
                dfs(row to col)
                count++
            }
        }
    }

    return count
}

private fun dfs(start: Pair<Int, Int>) {
    dr.forEachIndexed { index, it ->
        val (nr, nc) = start.first + it to start.second + dc[index]
        if (nr in rowRange && nc in colRange && map[nr][nc] == 1 && !visit[nr][nc]) {
            visit[nr][nc] = true
            dfs(nr to nc)
        }
    }
}