package binarysearch_parametricsearch

import java.util.*

// 날카로운 눈

private val br = System.`in`.bufferedReader()
private val n = br.readLine().toInt()
private val A = LongArray(n); private val B = LongArray(n); private val C = LongArray(n)
private var minimum = Long.MAX_VALUE; private var maximum = 0L

fun main() {
    for (i in 0 until n) {
        with(StringTokenizer(br.readLine())) {
            A[i] = nextToken().toLong()
            C[i] = nextToken().toLong()
            B[i] = nextToken().toLong()
            minimum = minOf(minimum, A[i])
            maximum = maxOf(maximum, C[i])
        }
    }
    maximum ++
    var low = minimum; var high = maximum

    while (low < high) {
        val mid = (low + high) / 2
        if (getSum(mid)%2 == 0L) low = mid + 1
        else high = mid
    }

    if (low == maximum) println("NOTHING")
    else println("$low ${getSum(low)- getSum(low-1)}")

}

//  정수더미에 있는 수중에서 x보다 작거나 같은수
private fun getSum(mid: Long): Long {
    var sum = 0L
    for (i in 0 until n) {
        if (mid >= A[i]) sum += (minOf(mid, C[i]) - A[i]) / B[i] + 1
    }
    return sum
}