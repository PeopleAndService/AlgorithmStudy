package boj.code_plus2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

//  테트로미노

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val paper = Array(n) { StringTokenizer(br.readLine()).run { IntArray(m) { nextToken().toInt() } } }

    val tetro = arrayOf(
        arrayOf(0 to 1, 0 to 2, 0 to 3), arrayOf(1 to 0, 2 to 0, 3 to 0), arrayOf(0 to 1, 1 to 0, 1 to 1), arrayOf(1 to 0, 2 to 0, 2 to 1),
        arrayOf(1 to 0, 2 to 0, 2 to -1), arrayOf(0 to 1, 0 to 2, 1 to 0), arrayOf(0 to 1, 0 to 2, 1 to 2), arrayOf(1 to 0, 1 to 1, 1 to 2),
        arrayOf(1 to 0, 1 to -1, 1 to -2), arrayOf(0 to 1, 1 to 1, 2 to 1), arrayOf(0 to 1, 1 to 0, 2 to 0), arrayOf(0 to 1, 0 to 2, 1 to 1),
        arrayOf(0 to 1, -1 to 1, 1 to 1), arrayOf(-1 to -1, 0 to -1, 1 to -1), arrayOf(1 to -1, 1 to 0, 1 to 1), arrayOf(1 to 0, 1 to 1, 2 to 1),
        arrayOf(1 to 0, 1 to -1, 2 to -1), arrayOf(0 to 1, -1 to 1, -1 to 2), arrayOf(0 to 1, 1 to 1, 1 to 2)
    )

    var answer = 0

    for (i in 0 until n) {
        for (j in 0 until m) {
            tetro.forEach {t ->
                var sum = paper[i][j]
                var flag = true

                t.forEach {
                    val nx = i + it.first
                    val ny = j + it.second

                    if (nx !in 0 until n || ny !in 0 until m) {
                        flag = false
                        return@forEach
                    }

                    sum += paper[nx][ny]
                }

                if (flag) answer = maxOf(answer, sum)
            }
        }
    }

    bw.write("$answer")
    bw.flush()
    bw.close()
}