package baekjoon.math

import java.util.StringTokenizer

// 패션왕 신해빈

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    repeat(br.readLine().toInt()) {
        val n = br.readLine().toInt()
        val list: List<Pair<String, String>> = List(n) { with(StringTokenizer(br.readLine())) { Pair(nextToken(), nextToken()) } }
        val group = list.groupBy { it.second }
        var answer = 1
        for (item in group.values) {
            answer *= (item.size + 1)
        }
        bw.write("${answer-1}\n")
    }

    bw.close()
}