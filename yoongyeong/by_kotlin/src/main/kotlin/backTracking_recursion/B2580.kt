package backTracking_recursion

import kotlin.system.exitProcess

// 스도쿠

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private val rowVisited = Array(9) { BooleanArray(9) }
private val colVisited = Array(9) { BooleanArray(9) }
private val squareVisited = Array(9) { BooleanArray(9) }

private val map = Array(9) { IntArray(9) }
private val blanks = mutableListOf<Pair<Int, Int>>()

fun main() {
    repeat(9) { row ->
        br.readLine().split(" ").map { it.toInt() }.forEachIndexed { col, number ->
            map[row][col] = number
            if (number == 0) {
                blanks.add(Pair(row, col))
            } else {
                rowVisited[row][number - 1] = true
                colVisited[col][number - 1] = true
                squareVisited[(row / 3) * 3 + col / 3][number - 1] = true
            }
        }
    }
    sudoku()
}

private fun sudoku(depth: Int = 0) {

    if (depth == blanks.size) {
        repeat(9) { bw.write(map[it].joinToString(" ", postfix = "\n")) }
        bw.flush()
        bw.close()
        exitProcess(0)
    }

    val (row, col) = blanks[depth]

    for (number in 1..9) {
        if (!rowVisited[row][number - 1] && !colVisited[col][number - 1]
            && !squareVisited[(row / 3) * 3 + col / 3][number - 1]) {
            map[row][col] = number
            rowVisited[row][number - 1] = true; colVisited[col][number - 1] = true
            squareVisited[(row / 3) * 3 + col / 3][number - 1] = true
            sudoku(depth + 1)
            rowVisited[row][number - 1] = false; colVisited[col][number - 1] = false
            squareVisited[(row / 3) * 3 + col / 3][number - 1] = false
        }
    }
}