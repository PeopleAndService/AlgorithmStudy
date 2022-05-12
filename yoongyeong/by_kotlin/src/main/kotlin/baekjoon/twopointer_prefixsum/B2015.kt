package baekjoon.twopointer_prefixsum

import java.util.StringTokenizer

// 수들의 합 4

fun main() {
    val br = System.`in`.bufferedReader()
    val n: Int; val k: Long
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt(); k = nextToken().toLong()
    }
    val array = LongArray(n+1); var answer = 0L
    val hash = mutableMapOf<Long, Long>()

    with(StringTokenizer(br.readLine())) {
        for (i in 1 .. n) {
            array[i] += array[i-1] + nextToken().toInt()
            if (array[i] == k) answer++
            answer += hash.getOrDefault(array[i] - k, 0)
            if (!hash.containsKey(array[i])) hash[array[i]] = 1L
            else hash[array[i]] = hash.getOrDefault(array[i], 0) + 1
        }
    }

    print(answer)
}