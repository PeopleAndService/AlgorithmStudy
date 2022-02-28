package binarysearch_parametricsearch

import java.util.*

// 나무 자르기

fun main() {
    val br = System.`in`.bufferedReader()
    var n = 0; var m = 0L
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        m = nextToken().toLong()
    }
    val trees = StringTokenizer(br.readLine()).run { LongArray(n.toInt()) {nextToken().toLong()} }
    val maximum = trees.maxOf { it }
    var low = (maximum - m).run { if(this < 0) 0L else this }; var high = maximum; var mid = 0L

    while (low <= high) {
        mid = (low + high) / 2
        if (getTree(trees, mid) < m)  high = mid - 1
        else low = mid + 1
    }
    print(high)
}

private fun getTree(trees: LongArray, cutting: Long) = trees.sumOf { (it - cutting).run { if(this < 0) 0 else this } }