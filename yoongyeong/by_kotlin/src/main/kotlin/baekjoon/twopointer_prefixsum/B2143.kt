package baekjoon.twopointer_prefixsum

import java.util.StringTokenizer

// 두 배열의 합

fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()

    val arrayA = IntArray(1001); val arrayB = IntArray(1001)
    val listA = mutableListOf<Int>(); val listB = mutableListOf<Int>()
    var result = 0L

    val n = br.readLine().toInt()
    with(StringTokenizer(br.readLine())) {
        for (i in 1 .. n) {
            arrayA[i] += arrayA[i-1] + nextToken().toInt()
            for (j in 0 until i) listA.add(arrayA[i] - arrayA[j])
        }
    }

    val m = br.readLine().toInt()
    with(StringTokenizer(br.readLine())) {
        for (i in 1 .. m) {
            arrayB[i] += arrayB[i-1] + nextToken().toInt()
            for (j in 0 until i) listB.add(arrayB[i] - arrayB[j])
        }
    }

    listB.sort()

    for (number in listA) {
        val targetNumber = t - number
        result += (getIdx(targetNumber, listB, false) - getIdx(targetNumber, listB, true))
    }

    print(result)

}

private fun getIdx(target: Int, array: List<Int>, isLower: Boolean): Int {
    var start = 0; var end = array.size

    while (start < end) {
        val mid = (start + end) / 2
        when {
            array[mid] > target -> end = mid
            array[mid] == target && isLower -> end = mid
            else -> start = mid + 1
        }
    }

    return start
}
