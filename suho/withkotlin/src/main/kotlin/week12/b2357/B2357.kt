package baekjoon.b2357

import java.util.*

/*
플랫폼 : 백준
문제번호 : 2357
문제제목 : 최솟값과 최댓값
난이도 : 골드 1
제한사항 : 2초/196MB
알고리즘 분류 : 자료 구조, 세그먼트 트리

알고리즘 설명
세그먼트 트리가 구간 합에 대한 트리인데, 구간 합 대신 구간 최솟값, 최대값을 저장

채점 결과 : 712ms/71700KB
풀이 날짜 : 2022/04/13
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n: Int
    val m: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }

    val arr = IntArray(n + 1)
    for (i in 1..n) {
        arr[i] = br.readLine().toInt()
    }

    val minSeg = MinSeg(n).apply { init(arr) }
    val maxSeg = MaxSeg(n).apply { init(arr) }

    repeat(m) {
        val min: Int
        val max: Int
        StringTokenizer(br.readLine()).run {
            val left = nextToken().toInt()
            val right = nextToken().toInt()

            min = minSeg.findRangeMin(left, right)
            max = maxSeg.findRangeMax(left, right)
        }

        bw.write("$min $max")
        bw.newLine()
    }

    bw.close()
    br.close()
}

private class MinSeg(private val n: Int) {
    private val minSeg = IntArray(n * 4)

    fun init(arr: IntArray, start: Int = 1, end: Int = n, node: Int = 1): Int {
        if (start == end) {
            minSeg[node] = arr[start]
            return minSeg[node]
        }

        val mid = (start + end) / 2

        minSeg[node] = minOf(init(arr, start, mid, node * 2), init(arr, mid + 1, end, node * 2 + 1))
        return minSeg[node]
    }

    fun findRangeMin(left: Int, right: Int, start: Int = 1, end: Int = n, node: Int = 1): Int {
        if (right < start || left > end) {
            return Int.MAX_VALUE
        }

        if (left <= start && end <= right) {
            return minSeg[node]
        }

        val mid = (start + end) / 2

        return minOf(
            findRangeMin(left, right, start, mid, node * 2),
            findRangeMin(left, right, mid + 1, end, node * 2 + 1)
        )
    }
}

private class MaxSeg(private val n: Int) {
    private val maxSeg = IntArray(n * 4)

    fun init(arr: IntArray, start: Int = 1, end: Int = n, node: Int = 1): Int {
        if (start == end) {
            maxSeg[node] = arr[start]
            return maxSeg[node]
        }

        val mid = (start + end) / 2

        maxSeg[node] = maxOf(init(arr, start, mid, node * 2), init(arr, mid + 1, end, node * 2 + 1))
        return maxSeg[node]
    }

    fun findRangeMax(left: Int, right: Int, start: Int = 1, end: Int = n, node: Int = 1): Int {
        if (right < start || left > end) {
            return Int.MIN_VALUE
        }

        if (left <= start && end <= right) {
            return maxSeg[node]
        }

        val mid = (start + end) / 2

        return maxOf(
            findRangeMax(left, right, start, mid, node * 2),
            findRangeMax(left, right, mid + 1, end, node * 2 + 1)
        )
    }
}