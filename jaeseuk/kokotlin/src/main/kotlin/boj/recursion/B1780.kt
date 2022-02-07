package boj.recursion

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private val n = br.readLine().toInt()

private val paper = Array(n) { br.readLine().split(" ") }

private var m = 0
private var z = 0
private var o = 0

fun main() {
    solution()

    bw.append("$m\n$z\n$o")
    bw.flush()
    bw.close()
}

private fun check(sx: Int, sy: Int, ex: Int, ey: Int): Boolean {
    val type = paper[sx][sy]

    for (i in sx until ex) {
        for (j in sy until ey) {
            if (type != paper[i][j]) return false
        }
    }

    when (type) {
        "-1" -> m++
        "0" -> z++
        "1" -> o++
    }

    return true
}

private fun solution(sx: Int = 0, sy: Int = 0, ex: Int = n - 1, ey: Int = n - 1, d: Int = n / 3) {
    if (check(sx, sy, ex, ey)) return

    val nd = d / 3

    for (i in sx..sx + d * 2 step d) {
        for (j in sy..sy + d * 2 step d) {
            solution(i, j, i + d, j + d, nd)
        }
    }
}