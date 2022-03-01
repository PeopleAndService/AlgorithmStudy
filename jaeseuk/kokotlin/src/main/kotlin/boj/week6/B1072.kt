package boj.week6

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

//  게임

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (x, y) = br.readLine().split(" ").map { it.toDouble() }
    val z = (y * 100 / x).toInt()

    var start = 1
    var end = x.toInt()

    var answer = -1

    while (start <= end) {
        val mid = (start + end) / 2
        val nz = ((y + mid) * 100 / (x + mid)).toInt()
        println("$nz $z")
        if (nz != z) {
            answer = if (answer == -1) mid else minOf(answer, mid)
            end = mid - 1
        } else {
            start = mid + 1
        }
    }

    bw.append("$answer")
    bw.flush()
    bw.close()
}