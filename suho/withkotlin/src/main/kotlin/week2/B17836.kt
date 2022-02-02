package week2

import java.util.*

/*
플랫폼 : 백준
문제번호 : 17836
문제제목 : 공주님을 구해라!
난이도 : 골드 5
제한사항 : 1초/256MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, BFS

알고리즘 설명
1. 각 칸에 대해서 칼을 갖고 방문하는 경우와 안갖고 방문하는 경우 2가지가 존재하기 때문에 방문 배열을 3차원으로 사용해야함
    -> [r][c][0]은 칼을 안갖고 방문, [r][c][1]은 칼을 갖고 방문
2. 그 외에는 일반 BFS와 동일
3. 시작은 (0, 0)에서 칼을 안갖고 시작
4. 인접 칸 방문하면서 칼을 안갖고 있는 상태면 0 또는 2인 칸만 탐색할 수 있고 또한 그 칸에 칼을 안갖고 방문한 상태여야 한다.
    -> 2인 칸을 방문했으면 칼 갖고 있는 상태를 true로 바꿔줘야함. 이외의 경우 이전 상태를 이어 받음
5. 칼을 갖고 있는 상태면 같은 상태로 방문만 안했으면 탐색 가능 -> 시간만 1시간 늘려서 계속 진행
6. 계속 진행하다가 끝 칸에 도달하면 공주에게 도달하는 최단 시간임이 보장되므로(BFS이기 때문) 시간 출력
7. 진행 도중 T시간을 넘어가거나 큐가 비게 되면 구출 불가

* 2206 벽 부수고 이동하기와 비슷한 문제!

채점 결과 : 196ms/16548KB
풀이 날짜 : 2022/02/02
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private val dr = intArrayOf(0, 0, -1, 1)
private val dc = intArrayOf(-1, 1, 0, 0)

private var n = 0
private var m = 0
private var t = 0
private lateinit var rowRange: IntRange
private lateinit var colRange: IntRange

private lateinit var castle: Array<IntArray>
private lateinit var visit: Array<Array<BooleanArray>>

fun main() {
    StringTokenizer(br.readLine()).run {
        n = nextToken().toInt()
        m = nextToken().toInt()
        t = nextToken().toInt()
        rowRange = 0 until n
        colRange = 0 until m
    }
    castle = Array(n) {
        StringTokenizer(br.readLine()).run {
            IntArray(m) { nextToken().toInt() }
        }
    }
    // [r][c][0]은 칼을 안갖고 방문, [r][c][1]은 칼을 갖고 방문
    visit = Array(n) { Array(m) { BooleanArray(2) } }

    bw.write(bfs())
    bw.close()
    br.close()
}

private data class State(val r: Int, val c: Int, val time: Int, val hasKnife: Boolean)

private fun bfs(): String {
    val queue = LinkedList<State>()
    queue.offer(State(0, 0, 0, false))
    visit[0][0][0] = true

    while (queue.isNotEmpty()) {
        val (r, c, time, hasKnife) = queue.poll()

        if (time > t) break
        if (r == n - 1 && c == m - 1) return "$time"

        repeat(4) {
            val nr = r + dr[it]
            val nc = c + dc[it]
            if (nr in rowRange && nc in colRange) {
                if (hasKnife) {
                    if (!visit[nr][nc][1]) {
                        visit[nr][nc][1] = true
                        queue.offer(State(nr, nc, time + 1, hasKnife))
                    }
                } else {
                    if (!visit[nr][nc][0]) {
                        if (castle[nr][nc] == 2) {
                            visit[nr][nc][0] = true
                            queue.offer(State(nr, nc, time + 1, true))
                        } else if (castle[nr][nc] == 0) {
                            visit[nr][nc][0] = true
                            queue.offer(State(nr, nc, time + 1, hasKnife))
                        }
                    }
                }
            }
        }
    }

    return "Fail"
}