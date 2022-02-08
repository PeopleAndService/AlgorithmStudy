package week3

import kotlin.math.abs

/*
채점 결과 : 5464ms/13052KB
풀이 날짜 : 2022/02/07
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private lateinit var queen: IntArray
private var answer = 0
private var n = 0

fun main() {
    n = br.readLine().toInt()
    queen = IntArray(n)
    dfs(0)
    bw.write("$answer")
    bw.close()
    br.close()
}

private fun dfs(row: Int) {
    if (row == n) {
        answer++
        return
    }

    for (col in 0 until n) {
        queen[row] = col
        if (check(row)) {
            dfs(row + 1)
        }
    }
}

private fun check(cur: Int): Boolean {
    for (row in 0 until cur) {
        if (queen[cur] == queen[row]) return false
        if (abs(cur - row) == abs(queen[cur] - queen[row])) return false
    }
    return true
}