package boj.code_plus2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

//  사탕 게임

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private val n = br.readLine().toInt()
private val board = Array(n) { br.readLine().toCharArray() }

private var answer = 0

fun main() {
    val dx = intArrayOf(0, 1)
    val dy = intArrayOf(1, 0)

    for (i in 0 until n) {
        for (j in 0 until n) {
            repeat(2) {
                val nx = i + dx[it]
                val ny = j + dy[it]

                if (nx < n && ny < n) {
                    board[i][j] = board[nx][ny].also { board[nx][ny] = board[i][j] }
                    calc(i, j, nx, ny)
                    board[i][j] = board[nx][ny].also { board[nx][ny] = board[i][j] }
                }
            }
        }
    }

    bw.write("$answer")
    bw.flush()
    bw.close()
}

private fun calc(x: Int, y: Int, nx:Int, ny:Int) {
    if (x < nx) {
        colCalc(y)
        rowCalc(x)
        rowCalc(nx)
    } else {
        rowCalc(x)
        colCalc(y)
        colCalc(ny)
    }
}

private fun colCalc(y: Int) {
    var ch = board[0][y]
    var cnt = 1
    var maxCnt = 0

    for (i in 1 until n) {
        if (ch == board[i][y]) {
            cnt++
        } else {
            maxCnt = maxOf(maxCnt, cnt)
            cnt = 1
            ch = board[i][y]
        }
    }

    maxCnt = maxOf(maxCnt, cnt)
    answer = maxOf(answer, maxCnt)
}

private fun rowCalc(x: Int) {
    var ch = board[x][0]
    var cnt = 1
    var maxCnt = 0

    for (i in 1 until n) {
        if (ch == board[x][i]) {
            cnt++
        } else {
            maxCnt = maxOf(maxCnt, cnt)
            cnt = 1
            ch = board[x][i]
        }
    }

    maxCnt = maxOf(maxCnt, cnt)
    answer = maxOf(answer, maxCnt)
}