package week11

import java.util.Comparator
import java.util.StringTokenizer

/*
플랫폼 : 백준
문제번호 : 7785
문제제목 : 회사에 있는 사람
난이도 : 실버 5
제한사항 : 1초/256MB
알고리즘 분류 : 자료 구조, 해시를 사용한 집합과 맵

알고리즘 설명
Set 자료구조 사용

채점 결과 : 540ms/46300KB
풀이 날짜 : 2022/04/04
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val set = sortedSetOf<String>(Comparator.reverseOrder())

    repeat(n) {
        with(StringTokenizer(br.readLine())) {
            val name = nextToken()
            val type = nextToken()

            if (type == "enter") set.add(name) else set.remove(name)
        }
    }

    for (p in set) {
        bw.write(p)
        bw.newLine()
    }

    bw.close()
    br.close()
}