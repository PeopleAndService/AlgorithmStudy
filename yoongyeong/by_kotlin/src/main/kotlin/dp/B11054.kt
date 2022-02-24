package dp

import java.util.*

// 가장 긴 바이토닉 부분 수열

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val array = StringTokenizer(br.readLine()).run { IntArray(n) {nextToken().toInt()} }
    val dpL = IntArray(n) {1}; val dpR = IntArray(n) {1}

    for (i in 1 until n) {
        for (j in 0 until i) {
            if (array[i] > array[j]) dpL[i] = maxOf(dpL[i], dpL[j] + 1)
        }
    }

    for (i in (n-2) downTo 0) {
        for (j in (n-1) downTo (i+1)) {
            if (array[i] > array[j]) dpR[i] = maxOf(dpR[i], dpR[j]+1)
        }
    }

    print(dpL.mapIndexed {index, i -> i + dpR[index] }.maxOf { it - 1 })
}