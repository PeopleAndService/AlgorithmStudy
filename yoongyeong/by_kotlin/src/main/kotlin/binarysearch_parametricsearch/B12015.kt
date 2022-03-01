package binarysearch_parametricsearch

import java.util.*

// 가장 긴 증가하는 부분 수열 2

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val a = StringTokenizer(br.readLine()).run { IntArray(n) {nextToken().toInt()} }
    val arr = mutableListOf(Int.MIN_VALUE)

    for (item in a) {
        if (arr.last() < item) arr.add(item)
        else arr[bisect(arr, item)] = item
    }

    print(arr.size-1)
}

private fun bisect(arr: MutableList<Int>, n: Int): Int {
    var low = 0; var high = arr.lastIndex

    while (low <= high) {
        val mid = (low + high) / 2

        when {
            arr[mid] == n -> return mid
            arr[mid] > n -> high = mid - 1
            else -> low = mid + 1
        }
    }
    return low
}