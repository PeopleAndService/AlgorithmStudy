package boj.week6

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.abs

//  두 용액

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val liquid = StringTokenizer(br.readLine()).run { IntArray(n) { nextToken().toInt() }.sortedArray() }

    var answer = 1_000_000_000 to 1_000_000_000

    var start = 0
    var end = n - 1

    while (start < end) {
        answer = minOf(answer, liquid[start] to liquid[end], compareBy { abs(it.first + it.second) })

        if (liquid[start] + liquid[end] < 0) start++
        else end--
    }

    bw.append("${answer.first} ${answer.second}")
    bw.flush()
    bw.close()
}