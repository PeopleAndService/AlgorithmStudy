package week7

import java.util.StringTokenizer
import kotlin.math.max

/*
플랫폼 : 백준
문제번호 : 2616
문제제목 : 소형기관차
난이도 : 골드 4
제한사항 : 1초/128MB
알고리즘 분류 : DP, 누적 합

알고리즘 설명
1. 각 객차의 손님을 누적 합 배열로 만든다.
2. dp로 i번째 기관차로 j개의 객차를 끌었을 때 최대 손님 수를 저장

채점 결과 : 192ms/19032KB
풀이 날짜 : 2022/03/06
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val trains = with(StringTokenizer(br.readLine())) {
        var sum = 0
        IntArray(n+1) { idx -> if (idx == 0) 0 else {
            sum += nextToken().toInt()
            sum
        } }
    }
    val k = br.readLine().toInt()
    val dp = Array(4) { IntArray(n+1) }
    for (i in 1..3) {
        for (j in i*k..n) {
            dp[i][j] = max(dp[i][j-1], dp[i-1][j-k] + (trains[j] - trains[j-k]))
        }
    }
    bw.write("${dp[3][n]}")
    bw.close()
    br.close()
}