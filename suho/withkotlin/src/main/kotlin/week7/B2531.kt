package week7

import java.util.StringTokenizer
import kotlin.math.max

/*
플랫폼 : 백준
문제번호 : 2531
문제제목 : 회전 초밥
난이도 : 실버 1
제한사항 : 1초/256MB
알고리즘 분류 : 투 포인터

알고리즘 설명
1. 슬라이딩 윈도우 + 투 포인터
2. 대신 슬라이딩 윈도우를 담는 자료 구조를 따로 쓰지 않음 -> 초밥 종류의 수만 필요하기 때문
3. 초밥 종류 별로 먹은 횟수 저장하는 배열하나 사용

채점 결과 : 220ms/21412KB
풀이 날짜 : 2022/03/05
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n: Int
    val d: Int
    val k: Int
    val c: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        d = nextToken().toInt()
        k = nextToken().toInt()
        c = nextToken().toInt()
    }

    val dishes = IntArray(n) { br.readLine().toInt() }
    val eat = IntArray(d + 1)
    var kind = 0
    dishes.take(k).forEach {
        if (eat[it] == 0) {
            kind++
        }
        eat[it]++
    }

    var answer = 0
    for (start in 1 until n) {
        answer = max(answer, if (eat[c] > 0) kind else kind + 1)

        val end = (start + k - 1) % n
        if (eat[dishes[end]] == 0) kind++
        eat[dishes[end]]++

        eat[dishes[start-1]]--
        if (eat[dishes[start-1]] == 0) kind--
    }

    bw.write("$answer")
    bw.close()
    br.close()
}