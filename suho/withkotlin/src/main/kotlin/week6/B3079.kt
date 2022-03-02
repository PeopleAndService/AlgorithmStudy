package week6

import java.util.*

/*
플랫폼 : 백준
문제번호 : 3079
문제제목 : 입국심사
난이도 : 골드 5
제한사항 : 1초/128MB
알고리즘 분류 : 이분탐색, 파라매트릭서치

알고리즘 설명
문제 주석

채점 결과 : 464ms/28312KB
풀이 날짜 : 2022/03/01
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n: Int
    val m: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    val times = IntArray(n) { br.readLine().toInt() }.sortedArray()
    var answer = 0L
    var start = 0L
    // 끝 범위는 가장 긴 입국 심사대에 m명이 전부 했을 경우
    var end = times.last().toLong() * m.toLong()
    while (start <= end) {
        val mid = (start + end) / 2
        // 총 입국 심사에 걸리는 시간으로 이분탐색, 총 시간 / 심사대에 걸리는 시간으로 몇 명을 심사할 수 있는지 본다.
        val count = times.sumOf { (mid / it) }
        if (count < m) {
            start = mid + 1
        } else {
            answer = mid
            end = mid - 1
        }
    }
    bw.write("$answer")
    bw.close()
    br.close()
}