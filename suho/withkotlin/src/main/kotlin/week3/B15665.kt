package week3

import java.util.*
import kotlin.collections.LinkedHashSet

/*
플랫폼 : 백준
문제번호 : 15665
문제제목 : N과 M (11)
난이도 : 실버 2
제한사항 : 1초/512MB
알고리즘 분류 : 백트래킹

알고리즘 설명
1. 주어진 배열 정렬
2. 중복 순열 구하기
3. 주어진 숫자들에도 중복이 있어서 다른 요소를 썼지만 같은 순열이 나올 수 있음 -> 이는 제거해야됌
4. 순열을 오름차순으로 출력하기 위해서 요소 삽입 순서를 유지하는 LinkedHashSet 사용

채점 결과 :
풀이 날짜 : 2022/02/05
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private var n = 0
private var m = 0

private lateinit var nums: List<Int>
private lateinit var perms: LinkedHashSet<String>

fun main() {
    StringTokenizer(br.readLine()).run {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    nums = br.readLine().split(" ").map { it.toInt() }.sorted()
    perms = LinkedHashSet()
    repeatPerm(0, IntArray(m))
    bw.write(perms.joinToString("\n"))
    bw.close()
    br.close()
}

private fun repeatPerm(depth: Int, arr: IntArray) {
    if (depth == m) {
        perms.add(arr.joinToString(" "))
        return
    }

    nums.forEach {
        arr[depth] = it
        repeatPerm(depth + 1, arr)
    }
}