package week3

import java.util.*

/*
플랫폼 : 백준
문제번호 : 15652
문제제목 : N과 M (4)
난이도 : 실버 3
제한사항 : 1초/512MB
알고리즘 분류 : 백트래킹

알고리즘 설명
중복조합

채점 결과 : 백트래킹 - 180ms/23044KB, 재귀 - 172ms/22540KB
풀이 날짜 : 2022/02/04
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private var n = 0
private var m = 0

fun main() {
    StringTokenizer(br.readLine()).run {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    repeatCombRE(0, 1, IntArray(m))
    bw.close()
    br.close()
}

// 백트래킹
private fun repeatCombBT(depth: Int, index: Int, arr: IntArray) {
    if (depth == m) {
        bw.write(arr.joinToString(" ", postfix = "\n"))
        return
    }

    for (i in index..n) {
        arr[depth] = i
        repeatCombBT(depth + 1, i, arr)
    }
}

// 재귀
private fun repeatCombRE(depth: Int, index: Int, arr: IntArray) {
    if (depth == m) {
        bw.write(arr.joinToString(" ", postfix = "\n"))
        return
    }

    if (index > n) return // if (index == n) return

    arr[depth] = index
    repeatCombRE(depth + 1, index, arr)
    repeatCombRE(depth, index + 1, arr)
}