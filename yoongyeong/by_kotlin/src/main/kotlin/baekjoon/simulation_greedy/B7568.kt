package baekjoon.simulation_greedy

import java.util.StringTokenizer

// 덩치

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val person = Array(n) { IntArray(2) }
    val result = IntArray(n) {1}

    for (idx in 0 until n) {
        with(StringTokenizer(br.readLine())) {
            person[idx][0] = nextToken().toInt()
            person[idx][1] = nextToken().toInt()
        }
    }

    for (i in 0 until n) {
        for (j in i+1 until n) {
            if (person[i][0] > person[j][0] && person[i][1] > person[j][1]) {
                result[j] += 1
            } else if (person[i][0] < person[j][0] && person[i][1] < person[j][1]) {
                result[i] += 1
            }
        }
    }

    print(result.joinToString(" "))
}
