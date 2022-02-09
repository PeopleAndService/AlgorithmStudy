package week3

import java.util.*

/*
플랫폼 : 백준
문제번호 : 6603
문제제목 : 로또
난이도 : 실버 2
제한사항 : 1초/128MB
알고리즘 분류 : 수학, 조합론, 백트래킹, 재귀

알고리즘 설명
조합 알고리즘

채점 결과 : 140ms/19316KB
풀이 날짜 : 2022/02/08
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private lateinit var nums: List<Int>

private const val MAX_DEPTH = 6

/*fun main() {
    while (true) {
        val input = StringTokenizer(br.readLine())
        n = input.nextToken().toInt()
        if (n == 0) break
        nums = IntArray(n) { input.nextToken().toInt() }
        comb(0, 0, IntArray(MAX_DEPTH))
        bw.newLine()
    }

    bw.close()
    br.close()
}*/

fun main() {
    while (true) {
        nums = br.readLine().split(" ").map { it.toInt() }
        if (nums[0] == 0) break
        comb(0, 1, IntArray(MAX_DEPTH))
        bw.newLine()
    }

    bw.close()
    br.close()
}

private fun comb(depth: Int, index: Int, arr: IntArray) {
    if (depth == MAX_DEPTH) {
        bw.write(arr.joinToString(" ", postfix = "\n"))
        return
    }

    for (i in index..nums[0]) {
        arr[depth] = nums[i]
        comb(depth + 1, i + 1, arr)
    }
}