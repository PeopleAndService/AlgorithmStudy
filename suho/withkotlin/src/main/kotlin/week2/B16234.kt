package week2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.abs

/*
플랫폼 : 백준
문제번호 : 16234
문제제목 : 인구 이동
난이도 : 골드 5
제한사항 : 2초/512MB
알고리즘 분류 : 구현, 시뮬레이션, 그래프 이론, 그래프 탐색, BFS

알고리즘 설명
1. 먼저 인구이동이 일어나는 연합을 찾아야함 -> bfs
2. 이동이 일어나는 연합이 있다면 인구 이동을 시켜줌 -> swapPopulation
3. 지도의 모든 나라에 대해 확인했으면 day 증가, 한번도 이동이 일어나지 않으면 day 반환

채점 결과 : 688ms/302512KB
풀이 날짜 : 2022/01/30
*/

private val dir = arrayOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)

private var n = 0
private lateinit var range: IntRange
private lateinit var map: Array<IntArray>
private lateinit var visit: Array<BooleanArray>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (N, l, r) = br.readLine().split(" ").map { it.toInt() }
    n = N
    range = l..r
    map = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    bw.write("${solution()}")
    bw.close()
    br.close()
}

private fun solution(): Int {
    var days = 0
    while (true) {
        var flag = false
        visit = Array(n) { BooleanArray(n) }
        repeat(n) { r ->
            repeat(n) { c ->
                if (!visit[r][c]) {
                    bfs(r, c)?.let { result ->
                        swapPopulation(result.first, result.second)
                        flag = true
                    }
                }
            }
        }

        if (!flag) return days
        days++
    }
}

// 연합 만들기
private fun bfs(r: Int, c: Int): Pair<Int, MutableList<Pair<Int, Int>>>? {
    val queue = LinkedList<Pair<Int, Int>>()
    val list = mutableListOf<Pair<Int, Int>>()
    queue.offer(r to c)
    list.add(r to c)
    visit[r][c] = true
    var population = map[r][c]

    while (queue.isNotEmpty()) {
        val (curR, curC) = queue.poll()
        repeat(4) { d ->
            val (nr, nc) = curR + dir[d].first to curC + dir[d].second
            if (nr in 0 until n && nc in 0 until n && !visit[nr][nc]) {
                val diff = abs(map[curR][curC] - map[nr][nc])
                if (diff in range) {
                    queue.offer(nr to nc)
                    list.add(nr to nc)
                    population += map[nr][nc]
                    visit[nr][nc] = true
                }
            }
        }
    }

    return if (list.size > 1) (population / list.size) to list else null
}

// 인구 교체
private fun swapPopulation(pop: Int, target: MutableList<Pair<Int, Int>>) {
    target.forEach {
        map[it.first][it.second] = pop
    }
}