package boj.week7

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.abs

//  세 용액

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val liquid = StringTokenizer(br.readLine()).run { LongArray(n) { nextToken().toLong() }.sortedArray() }

    var answer = Triple(1_000_000_000L, 1_000_000_000L, 1_000_000_000L)

    for (i in 0..n - 3) {
        var mid = i + 1
        var end = n - 1

        while (mid < end) {
            val mix = Triple(liquid[i], liquid[mid], liquid[end])
            answer = minOf(answer, mix, compareBy { abs(it.first + it.second + it.third) })

            if (mix.first + mix.second + mix.third < 0) mid++
            else end--
        }
    }

    bw.append("${answer.first} ${answer.second} ${answer.third}")
    bw.flush()
    bw.close()
}