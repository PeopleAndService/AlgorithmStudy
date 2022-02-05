package boj.backtracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private var r = 0
private var c = 0

private lateinit var board: Array<String>
private val visited = BooleanArray(26)

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private var answer = 0

fun main() {
    br.readLine().split(" ").run {
        r = first().toInt()
        c = last().toInt()
    }

    board = Array(r) { br.readLine() }

    visited[board[0][0] - 'A'] = true
    solution(0, 0, 1)

    bw.append("$answer")
    bw.flush()
    bw.close()
}

private fun solution(x: Int, y: Int, cnt: Int) {
    repeat(4) {
        val nx = x + dx[it]
        val ny = y + dy[it]

        if (nx in 0 until r &&
            ny in 0 until c &&
            !visited[board[nx][ny] - 'A']
        ) {
            visited[board[nx][ny] - 'A']= true
            solution(nx, ny, cnt + 1)
            visited[board[nx][ny] - 'A'] = false
        }
    }

    answer = maxOf(answer, cnt)
}