package boj.recursion

import java.io.BufferedReader
import java.io.InputStreamReader

private val br = BufferedReader(InputStreamReader(System.`in`))

private val n = br.readLine().toInt()
private val video = Array(n) { br.readLine() }

private val sb = StringBuilder()

fun main() {
    pack()
    println(sb.toString())
}

private fun pack(sx: Int = 0, sy: Int = 0, ex: Int = n, ey: Int = n) {
    if (check(sx, sy, ex, ey)) return

    val nx = (sx + ex) / 2
    val ny = (sy + ey) / 2

    sb.append('(')
    pack(sx, sy, nx, ny)
    pack(sx, ny, nx, ey)
    pack(nx, sy, ex, ny)
    pack(nx, ny, ex, ey)
    sb.append(')')
}

private fun check(sx: Int, sy: Int, ex: Int, ey: Int): Boolean {
    val p = video[sx][sy]

    for (i in sx until ex) {
        for (j in sy until ey) {
            if (p != video[i][j]) return false
        }
    }

    sb.append(p)

    return true
}