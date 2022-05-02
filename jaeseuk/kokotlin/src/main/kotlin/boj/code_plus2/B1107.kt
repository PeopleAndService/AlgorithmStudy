package boj.code_plus2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.math.abs

// 리모컨

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    val broken = BooleanArray(10)

    if (m > 0) {
        with(StringTokenizer(br.readLine())) {
            while (hasMoreTokens()) {
                broken[nextToken().toInt()] = true
            }
        }
    }

    var answer = abs(n - 100)
    var channel = 999_999

    while (channel >= 0) {
        val channelStr = channel.toString()

        if (channelStr.all { !broken[it - '0'] }) {
            answer = minOf(answer, abs(channel - n) + channelStr.length)
        }

        channel--
    }

    bw.write("$answer")
    bw.flush()
    bw.close()
}