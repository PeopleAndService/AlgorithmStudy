package week3

import java.util.*

/*
플랫폼 : 백준
문제번호 : 15655
문제제목 : N과 M (6)
난이도 : 실버 3
제한사항 : 1초/512MB
알고리즘 분류 : 백트래킹

알고리즘 설명
1. 주어진 배열을 정렬
2. 주어진 배열로 조합 만들기

채점 결과 : 176ms/24036KB
풀이 날짜 : 2022/02/05
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private var n = 0
private var m = 0

private lateinit var nums: List<Int>

fun main() {
    StringTokenizer(br.readLine()).run {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    nums = br.readLine().split(" ").map { it.toInt() }.sorted()
    comb(0, 0, IntArray(m))
    bw.close()
    br.close()
}

private fun comb(depth: Int, index: Int, arr: IntArray) {
    if (depth == m) {
        bw.write(arr.joinToString(" ", postfix = "\n"))
        return
    }

    for (i in index until n) {
        arr[depth] = nums[i]
        comb(depth + 1, i + 1, arr)
    }
}