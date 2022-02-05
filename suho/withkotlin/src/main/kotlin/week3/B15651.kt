package week3

import java.util.*

/*
플랫폼 : 백준
문제번호 : 15651
문제제목 : N과 M (3)
난이도 : 실버 3
제한사항 : 1초/512MB
알고리즘 분류 : 백트래킹

알고리즘 설명
중복순열

채점 결과 : 732ms/259864ms
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
    repeatPerm(0, IntArray(m))
    bw.close()
    br.close()
}

private fun repeatPerm(depth: Int, arr: IntArray) {
    if (depth == m) {
        bw.write(arr.joinToString(" ", postfix = "\n"))
        return
    }

    for (i in 1..n) {
        arr[depth] = i
        repeatPerm(depth + 1, arr)
    }
}