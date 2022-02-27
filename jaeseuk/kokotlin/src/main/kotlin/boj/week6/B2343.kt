package boj.week6

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

//  절댓값 힙

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    var start = 0
    var end = 0

    val videos = StringTokenizer(br.readLine()).run {
        IntArray(n) {
            val video = nextToken().toInt()
            start = maxOf(start, video)
            end += video
            video
        }
    }

    var answer = end

    while (start <= end) {
        val mid = (start + end) / 2
        var cnt = 1
        var total = 0

        for (video in videos) {
            if (total + video <= mid) {
                total += video
            } else {
                cnt++
                total = video
            }
        }

        if (cnt <= m) {
            answer = minOf(answer, mid)
            end = mid - 1
        } else {
            start = mid + 1
        }
    }

    bw.append("$answer")
    bw.flush()
    bw.close()
}