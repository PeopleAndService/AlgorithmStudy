package boj.recursion

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.pow

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private var n = 0
private var r = 0
private var c = 0

fun main() {
    br.readLine().split(" ").run {
        n = 2.0.pow(first().toInt()).toInt()
        r = get(1).toInt()
        c = last().toInt()
    }

    solution()

    bw.flush()
    bw.close()
}

private fun solution(startX: Int = 0, startY: Int = 0, endX: Int = n, endY: Int = n, q: Int = 0) {
    if (r !in startX until endX || c !in startY until endY) return

    if (endX - startX == 1 && endY - startY == 1) {
        bw.append("$q")
        return
    }

    val nx = (startX + endX) / 2
    val ny = (startY + endY) / 2

    solution(startX, startY, nx, ny, q * 4)
    solution(startX, ny, nx, endY, q * 4 + 1)
    solution(nx, startY, endX, ny, q * 4 + 2)
    solution(nx, ny, endX, endY, q * 4 + 3)
}