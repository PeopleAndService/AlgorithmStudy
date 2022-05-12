package baekjoon.binarysearch_parametricsearch

import java.util.*

// 수 찾기

private lateinit var array: IntArray

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    array = StringTokenizer(br.readLine()).run { IntArray(n) {nextToken().toInt()} }.sortedArray()
    val m = br.readLine().toInt()
    val mArray = StringTokenizer(br.readLine()).run {
        repeat(m) {
            bw.write(if(searchNumber(nextToken().toInt())) "1\n" else "0\n")
        }
    }
    bw.close()
}

private fun searchNumber(number: Int): Boolean {
    var low = 0; var high = array.lastIndex

    while(low <= high) {
        val mid = (low+high) / 2

        when {
            array[mid] == number -> return true
            array[mid] > number -> high = mid - 1
            else -> low = mid + 1
        }
    }
    return false
}