package week6

import java.util.StringTokenizer

/*
플랫폼 : 백준
문제번호 : 6236
문제제목 : 용돈 관리
난이도 : 실버 2
제한사항 : 1초/128MB
알고리즘 분류 : 이분탐색, 파라매트릭 서치

알고리즘 설명
문제 주석

채점 결과 : 300ms/25048KB
풀이 날짜 : 2022/02/28
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
    val moneys = IntArray(n) { br.readLine().toInt() }
    var start = moneys.maxOf { it }
    var end = moneys.sum()
    var answer = 0
    while (start <= end) {
        val mid = (start + end) / 2 // 1회 인출 금액

        var total = mid
        var count = 1
        moneys.forEach {
            // 인출 금액으로 해당 날짜를 살 수 없으면 다시 인출
            if (total < it) {
                total = mid
                count++
            }
            total -= it // 해당 날짜 금액 사용
        }

        // 인출 횟수로 인출 금액 조절
        if (count > m) {
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