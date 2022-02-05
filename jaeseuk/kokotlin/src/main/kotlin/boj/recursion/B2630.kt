package boj.recursion

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private val n = br.readLine().toInt()

private val paper = Array(n) { br.readLine().split(" ") }

private var white = 0
private var blue = 0

fun main() {
    solution()

    bw.append("$white\n")
    bw.append("$blue\n")
    bw.flush()
    bw.close()
}

private fun solution(startX: Int = 0, startY: Int = 0, endX: Int = n, endY: Int = n) {
    if (check(startX, startY, endX, endY)) return

    val nx = (startX + endX) / 2
    val ny = (startY + endY) / 2

    solution(startX, startY, nx, ny)
    solution(startX, ny, nx, endY)
    solution(nx, startY, endX, ny)
    solution(nx, ny, endX, endY)
}

private fun check(startX: Int, startY: Int, endX: Int, endY: Int): Boolean {
    val color = paper[startX][startY]

    for (i in startX until endX) {
        for (j in startY  until endY) {
            if (paper[i][j] != color) return false
        }
    }

    if (color == "1") blue++
    else white++

    return true
}