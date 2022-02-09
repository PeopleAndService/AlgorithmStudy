package week3

import java.util.*

/*
플랫폼 : 백준
문제번호 : 1182
문제제목 : 부분수열의 합
난이도 : 실버 2
제한사항 : 2초/256MB
알고리즘 분류 : 브루트포스 알고리즘, 백트래킹

알고리즘 설명
부분수열 -> 부분집합 구하기 -> 조합알고리즘
1. 여기서는 부분집합의 크기가 1부터 n

채점 결과 : 204ms/18428KB
풀이 날짜 : 2022/02/09
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private var n = 0
private var s = 0

private lateinit var nums: IntArray
private var count = 0

fun main() {
    StringTokenizer(br.readLine()).run {
        n = nextToken().toInt()
        s = nextToken().toInt()
    }

    StringTokenizer(br.readLine()).run {
        nums = IntArray(n) { nextToken().toInt() }
    }

    for (r in 1..n) {
        comb(0, 0, r, IntArray(r))
    }

    bw.write("$count")
    bw.close()
    br.close()
}

private fun comb(depth: Int, index: Int, r: Int, arr: IntArray) {
    if (depth == r) {
        if (arr.sum() == s) count++
        return
    }

    for (i in index until n) {
        arr[depth] = nums[i]
        comb(depth + 1, i + 1, r, arr)
    }
}