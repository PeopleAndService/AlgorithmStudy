package baekjoon.dp

import java.util.StringTokenizer

// 연속합

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val numbers = with(StringTokenizer(br.readLine())) { IntArray(n) { nextToken().toInt() } }

    var maximum = numbers[0]
    var sum = 0

    for (number in numbers) {
        sum += number
        maximum = maxOf(maximum, sum)
        if (sum < 0) sum = 0
    }

    print(maximum)
}