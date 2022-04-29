package math

import java.util.StringTokenizer
import kotlin.math.abs

// 다각형의 면적

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val x = LongArray(n+1)
    val y = LongArray(n+1)
    var sumX = 0L
    var sumY = 0L

    for (index in 0 until n) {
        with(StringTokenizer(br.readLine())) {
            x[index] = nextToken().toLong()
            y[index] = nextToken().toLong()
        }
    }

    x[n] = x[0]
    y[n] = y[0]

    for (index in 0 until n) {
        sumX += x[index] * y[index+1]
        sumY += x[index+1] * y[index]
    }

    print("%.1f".format(abs(sumX - sumY) / 2.0))
}