package baekjoon.twopointer_prefixsum

import java.util.StringTokenizer

// 두 수의 합

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val a = StringTokenizer(br.readLine()).run { IntArray(n) {nextToken().toInt()} }.sortedArray()
    val x = br.readLine().toInt(); var result = 0
    var start = 0; var end = n - 1

    while (start < end) {
        when {
            a[start] + a[end] == x -> {result ++; start++; end--}
            a[start] + a[end] > x -> end--
            else -> start ++
        }
    }

    print(result)
}