package week3

import java.util.*

/*
플랫폼 : 백준
문제번호 : 15649
문제제목 : N과 M(1)
난이도 : 실버 3
제한사항 : 1초/512MB
알고리즘 분류 : 백트래킹

알고리즘 설명
순열

채점 결과 : 312ms/38584KB
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
    perm(0, IntArray(m), BooleanArray(n+1))
    bw.close()
    br.close()
}

private fun perm(depth: Int, arr: IntArray, visit: BooleanArray) {
    if (depth == m) {
        bw.write(arr.joinToString(" ", postfix = "\n"))
        return
    }

    for (i in 1..n) {
        if (!visit[i]) {
            visit[i] = true
            arr[depth] = i
            perm(depth + 1, arr, visit)
            visit[i] = false
        }
    }
}