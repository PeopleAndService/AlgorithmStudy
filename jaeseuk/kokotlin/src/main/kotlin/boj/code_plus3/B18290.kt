package boj.code_plus3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

//  NM과 K (1)

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private var n = 0
private var m = 0
private var k = 0

private lateinit var board: Array<IntArray>
private lateinit var used: Array<BooleanArray>

private val dx = intArrayOf(-1, 0, 1, 0, 0)
private val dy = intArrayOf(0, 1, 0, -1, 0)

private var answer = Int.MIN_VALUE

fun main() {
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
        k = nextToken().toInt()
    }

    board = Array(n) { StringTokenizer(br.readLine()).run { IntArray(m) { nextToken().toInt() } } }
    used = Array(n) { BooleanArray(m) }

    solution(0, 0)

    bw.write("$answer")
    bw.flush()
    bw.close()
}

private fun solution(sum: Int, step: Int) {
    if (step == k) {
        answer = maxOf(answer, sum)
        return
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (check(i, j)) {
                used[i][j] = true
                solution(sum + board[i][j], step + 1)
                used[i][j] = false
            }
        }
    }
}

private fun check(x: Int, y: Int): Boolean {
    repeat(5) {
        val nx = x + dx[it]
        val ny = y + dy[it]

        if (nx in 0 until n && ny in 0 until m && used[nx][ny]) return false
    }

    return true
}