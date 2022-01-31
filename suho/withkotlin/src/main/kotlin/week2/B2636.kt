package week2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/*
플랫폼 : 백준
문제번호 : 2636
문제제목 : 치즈
난이도 : 골드 5
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 그래프 이론, 그래프 탐색, BFS, 시뮬레이션

알고리즘 설명
1. 외벽은 항상 0임 (테두리) -> (0, 0)이 항상 0임
2. (0, 0)에서 시작해서 공기 칸들에 대해서 bfs하면 치즈와 맞닿은 부분만 체크할 수 있음
3. 다음 칸 확인할 때 치즈면 공기로 바꿔주고 공기면 queue에 넣어서 계속 bfs 할 수 있도록 한다.
4. 치즈의 수가 0이 될 때까지 반복 -> 처음 입력 받을 때 치즈의 수를 알아야함

채점 결과 : 240ms/26884KB
풀이 날짜 : 2022/01/31
*/

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private val dr = intArrayOf(0, 0, 1, -1)
private val dc = intArrayOf(1, -1, 0, 0)

private lateinit var rowRange: IntRange
private lateinit var colRange: IntRange

private var n = 0
private var m = 0

private lateinit var map: Array<IntArray>
private lateinit var visit: Array<BooleanArray>
private var cheese = 0

fun main() {
    br.readLine().split(" ").map { it.toInt() }.run {
        n = this.component1()
        m = this.component2()
        rowRange = 0 until n
        colRange = 0 until m
    }
    map = Array(n) {
        StringTokenizer(br.readLine()).run {
            IntArray(m) { nextToken().toInt().let {
                if (it == 1) cheese++
                it
            } }
        }
    }

    var time = 0
    var prev = 0
    while (cheese != 0) {
        prev = cheese
        bfs(0 to 0)
        time++
    }

    bw.write("$time\n$prev")
    bw.close()
    br.close()
}

private fun bfs(start: Pair<Int, Int>) {
    val queue = LinkedList<Pair<Int, Int>>()
    visit = Array(n) { BooleanArray(m) }
    queue.offer(start)
    visit[start.first][start.second] = true

    while (queue.isNotEmpty()) {
        val (r, c) = queue.poll()
        repeat(4) {
            val (nr, nc) = r + dr[it] to c + dc[it]
            if (nr in rowRange && nc in colRange && !visit[nr][nc]) {
                visit[nr][nc] = true
                if (map[nr][nc] == 1) {
                    cheese--
                    map[nr][nc] = 0
                } else {
                    queue.offer(nr to nc)
                }
            }
        }
    }
}