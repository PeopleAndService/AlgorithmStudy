package baekjoon.sort

import java.util.StringTokenizer

// 좌표 압축

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val list = with(StringTokenizer(br.readLine())) { List(n) { Pair(nextToken().toInt(), it) } }
    val answer = IntArray(n)

    val sortList = list.sortedBy { it.first }

    var count = 1
    var lastNumber = sortList[0].first

    for ((number, idx) in sortList) {

        if (lastNumber != number) {
            count++
            lastNumber = number
        }

        answer[idx] = count - 1
    }

    print(answer.joinToString(" "))
}