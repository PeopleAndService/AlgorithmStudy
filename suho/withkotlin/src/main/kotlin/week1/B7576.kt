package week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/*
플랫폼 : 백준
문제번호 : 7576
문제제목 : 토마토
난이도 : 골드 5
제한사항 : 1초/256MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, 너비우선탐색

알고리즘 설명
1. 토마토 -> 주변 4방향으로 전이
2. 입력 받아서 토마토가 있는 좌표를 큐에 넣고
3. 하루가 갈 때, 현재 토마토의 갯수(큐의 길이)만큼 전이를 확인해야함
4. 토마토를 가능한 모두 익게 한 후에 0이 있으면 -1 출력

채점 결과 : 996ms/174596KB
풀이 날짜 : 2022/01/28
*/

private val br by lazy { BufferedReader(InputStreamReader(System.`in`)) }
private val bw by lazy { BufferedWriter(OutputStreamWriter(System.out)) }

private val dr = intArrayOf(-1, 1, 0, 0)
private val dc = intArrayOf(0, 0, -1, 1)

fun main() {
    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val box = List(n) { br.readLine().split(" ").map { it.toInt() }.toMutableList() }
    br.close()

    val queue = LinkedList<Pair<Int, Int>>()
    box.forEachIndexed { r, rows ->
        rows.forEachIndexed { c, tomato ->
            if (tomato == 1) queue.offer(r to c)
        }
    }

    bw.write("${bfs(queue, box, n, m)}")
    bw.flush()
    bw.close()
}

private fun bfs(queue: Queue<Pair<Int, Int>>, box: List<MutableList<Int>>, n: Int, m: Int): Int {
    var day = -1
    while (queue.isNotEmpty()) {
        day++
        repeat(queue.size) {
            val (r, c) = queue.poll()
            repeat(4) {
                val nr = r + dr[it]
                val nc = c + dc[it]
                if (nr in 0 until n && nc in 0 until m && box[nr][nc] == 0) {
                    box[nr][nc] = 1
                    queue.offer(nr to nc)
                }
            }
        }
    }

    box.forEach {
        if (0 in it) return -1
    }

    return day
}