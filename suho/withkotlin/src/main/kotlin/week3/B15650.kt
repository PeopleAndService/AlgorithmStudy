package week3

import java.util.*

/*
플랫폼 : 백준
문제번호 : 15650
문제제목 : N과 M (2)
난이도 : 실버 3
제한사항 : 1초/512MB
알고리즘 분류 : 백트래킹

알고리즘 설명
조합

채점 결과 : 백트래킹 - 132ms/18408ms, 재귀 - 132ms/18428KB
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
    recursiveComb(0, 1, IntArray(m))
    bw.close()
    br.close()
}

private fun backtrackingComb(depth: Int, index: Int, arr: IntArray) {
    if (depth == m) {
        bw.write(arr.joinToString(" ", postfix = "\n"))
        return
    }

    for (i in index..n) {
        arr[depth] = i
        backtrackingComb(depth + 1, i + 1, arr)
    }
}

private fun recursiveComb(depth: Int, index: Int, arr: IntArray) {
    if (depth == m) {
        bw.write(arr.joinToString(" ", postfix = "\n"))
        return
    }

    if (index > n) return // if (index == n) return

    arr[depth] = index
    recursiveComb(depth + 1, index + 1, arr)
    recursiveComb(depth, index + 1, arr)
}