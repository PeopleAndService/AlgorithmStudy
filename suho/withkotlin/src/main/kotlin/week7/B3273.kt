package week7

import java.util.StringTokenizer

/*
플랫폼 : 백준
문제번호 : 3273
문제제목 : 두 수의 합
난이도 : 실버 3
제한사항 : 1초/128MB
알고리즘 분류 : 정렬, 투 포인터

알고리즘 설명
양 끝 투 포인터 사용

채점 결과 : 376ms/32056KB
풀이 날짜 : 2022/03/03
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val arr = with(StringTokenizer(br.readLine())) { IntArray(n) { nextToken().toInt() }.sortedArray() }
    val target = br.readLine().toInt()

    var start = 0
    var end = arr.lastIndex
    var answer = 0
    while (start < end) {
        val sum = arr[start] + arr[end]

        when {
            sum == target -> {
                start++
                end--
                answer++
            }
            sum < target -> start++
            else -> end--
        }
    }
    bw.write("$answer")
    bw.close()
    br.close()
}