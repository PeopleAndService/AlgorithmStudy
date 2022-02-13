package boj.week4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    var (r, c, d) = br.readLine().split(" ").map { it.toInt() }
    val place = Array(n) { StringTokenizer(br.readLine()).run { IntArray(m) { nextToken().toInt() } } }

    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(-1, 0, 1, 0)

    var answer = 0

    while (true) {
        if (place[r][c] == 0) {
            answer++
            place[r][c] = 2
        }

        var cleanable = false

        for (i in 0..3) {
            val nd = (8 - d + i) % 4
            val nx = r + dx[nd]
            val ny = c + dy[nd]

            if (place[nx][ny] == 0) {
                r = nx
                c = ny
                d = 3 - nd
                cleanable = true
                break
            }
        }

        if (!cleanable) {
            val nd = (9 - d) % 4
            val nx = r + dx[nd]
            val ny = c + dy[nd]

            if (place[nx][ny] == 1) {
                break
            } else {
                r = nx
                c = ny
            }
        }
    }

    bw.append("$answer")
    bw.flush()
    bw.close()
}