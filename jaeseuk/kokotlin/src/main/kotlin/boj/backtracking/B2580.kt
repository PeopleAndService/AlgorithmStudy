package boj.backtracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.system.exitProcess

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var sudoku: Array<Array<String>>
private val rowCheck = Array(9) { BooleanArray(9) }
private val colCheck = Array(9) { BooleanArray(9) }
private val miniCheck = Array(9) { BooleanArray(9) }

private val blanks = ArrayList<Pair<Int, Int>>()

fun main() {
    sudoku = Array(9) { row ->
        br.readLine().split(" ").toTypedArray().also {
            it.forEachIndexed { col, s ->
                if (s == "0") {
                    blanks.add(row to col)
                } else {
                    rowCheck[row][s.toInt() - 1] = true
                    colCheck[col][s.toInt() - 1] = true
                    miniCheck[(row / 3) * 3 + (col / 3)][s.toInt() - 1] = true
                }
            }
        }
    }

    solution(0)
}

private fun solution(idx: Int) {
    if (idx == blanks.size) {
        sudoku.forEach { bw.append(it.joinToString(separator = " ", postfix = "\n")) }
        bw.flush()
        bw.close()
        exitProcess(0)
    }

    val (x, y) = blanks[idx]
    val mini = (x / 3) * 3 + (y / 3)

    repeat(9) {
        if (!rowCheck[x][it] && !colCheck[y][it] && !miniCheck[mini][it]) {
            sudoku[x][y] = "${it + 1}"
            rowCheck[x][it] = true; colCheck[y][it] = true; miniCheck[mini][it] = true
            solution(idx + 1)
            sudoku[x][y] = "0"
            rowCheck[x][it] = false; colCheck[y][it] = false; miniCheck[mini][it] = false
        }
    }
}