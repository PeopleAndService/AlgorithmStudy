package baekjoon.twopointer_prefixsum

import java.util.StringTokenizer

// 부분합

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, s) = br.readLine().split(" ").map { it.toInt() }
    var sum = 0
    val array = StringTokenizer(br.readLine()).run { IntArray(n) { sum += nextToken().toInt(); sum } }
    var result = Int.MAX_VALUE

    var start = -1; var end = 0
    while (end in start until n) {
        (array[end] - if(start == -1) 0 else array[start]).run {
            when {
                this >= s -> {
                    result = minOf(result, end - start); start++
                }
                else -> end++

            }
        }
    }

    print(if(result==Int.MAX_VALUE)0 else result)
}