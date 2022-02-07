package backTracking_recursion

import java.io.BufferedReader
import java.io.InputStreamReader

// N-Queen

private val n = BufferedReader(InputStreamReader(System.`in`)).readLine().toInt()
private val chessBoard = Array(n) {IntArray(n)}

private val visited = BooleanArray(n)
private val crossMinus = BooleanArray(2 * n)
private val crossPlus = BooleanArray(2 * n)

private var cnt = 0

fun main() {
    playChess(0)
    print(cnt)
}

private fun playChess(r: Int) {

    if (r == n) {
        cnt += 1; return
    }

    for (c in 0 until n) {
        if (!checkChess(r, c)) {
            visited[c] = true; crossMinus[n+r-c] = true; crossPlus[r+c] = true
            playChess(r + 1)
            visited[c] = false; crossMinus[n+r-c] = false; crossPlus[r+c] = false
        }
    }
}

private fun checkChess(r: Int, c: Int) = visited[c] || crossMinus[n+r-c] || crossPlus[r+c]
