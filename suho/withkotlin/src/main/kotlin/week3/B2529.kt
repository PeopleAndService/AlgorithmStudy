package week3

import java.util.*

/*
플랫폼 : 백준
문제번호 : 2529
문제제목 : 부등호
난이도 : 실버 2
제한사항 : 1초/256MB
알고리즘 분류 : 브루트포스 알고리즘, 백트래킹

알고리즘 설명
연산자 끼워넣기의 부등호 버전. 숫자를 끼워 넣으면 되는데, 각 상태에서 다음 숫자를 집어넣을 때 부등호를 만족하도록 넣어야된다.
-> if 조건식 참고

채점 결과 : 304ms/37168KB
풀이 날짜 : 2022/02/07
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private var k = 0
private lateinit var arr: CharArray
private lateinit var visit: BooleanArray
private lateinit var result: SortedSet<String>

fun main() {
    k = br.readLine().toInt()
    arr = br.readLine().replace(" ", "").toCharArray()
    visit = BooleanArray(10)
    result = sortedSetOf()
    dfs(0, IntArray(k+1))
    bw.write("${result.last()}\n${result.first()}")
    bw.close()
    br.close()
}

private fun dfs(depth: Int, nums: IntArray) {
    if (depth == k+1) {
        result.add(nums.joinToString(""))
        return
    }

    for (nxt in 0..9) {
        if (depth == 0 || !visit[nxt] && if (arr[depth-1] == '<') nums[depth-1] < nxt else nums[depth-1] > nxt) {
            visit[nxt] = true
            nums[depth] = nxt
            dfs(depth + 1, nums)
            visit[nxt] = false
        }
    }
}