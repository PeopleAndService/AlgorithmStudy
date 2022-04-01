package boj.week11

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

//  문자열 잘라내기

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    val columns = Array(c) { "" }

    repeat(r) {
        br.readLine().forEachIndexed { index, c ->
            columns[index] = columns[index] + c
        }
    }

    var answer = 0
    var start = 1
    var end = r - 1

    while (start <= end) {
        val mid = (start + end) / 2

        val strings = mutableSetOf<String>()
        columns.forEach { strings.add(it.substring(mid)) }

        if (strings.size == c) {
            answer = mid
            start = mid + 1
        } else {
            end = mid - 1
        }
    }

    bw.write("$answer")
    bw.flush()
    bw.close()
}