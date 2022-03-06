package twopointer_prefixsum

import java.util.StringTokenizer

// 냅색문제

fun main() {
    val br = System.`in`.bufferedReader()
    val n: Int; val c: Long
    with(StringTokenizer(br.readLine())){
        n = nextToken().toInt()
        c = nextToken().toLong()
    }
    val bags = StringTokenizer(br.readLine()).run { LongArray(n) {nextToken().toLong()}}
    val leftBags = bags.sliceArray(0 until (n / 2))
    val rightBags = bags.sliceArray((n / 2) until n)

    val sumLeftBags = mutableListOf<Long>().apply { getSubsetAndSum(leftBags, this) }.sorted()
    val sumRightBags = mutableListOf<Long>().apply { getSubsetAndSum(rightBags, this) }.sorted()

    var result = 0L
    sumRightBags.forEach {
        if (it <= c) result += upperBound(sumLeftBags, c - it)
    }

    print(result)

}

private fun getSubsetAndSum(arr: LongArray, saveIn: MutableList<Long>, sum: Long = 0, idx: Int = 0, limit: Int = arr.size) {
    if (idx == limit) {saveIn.add(sum); return}
    getSubsetAndSum(arr, saveIn, sum+arr[idx], idx + 1, limit)
    getSubsetAndSum(arr, saveIn, sum, idx+1, limit)
}

private fun upperBound(list: List<Long>, value: Long): Int {
    var start = 0; var end = list.size

    while (start < end) {
        ((start + end) / 2).run {
            if (list[this] <= value) start = this + 1
            else end = this
        }
    }

    return end
}