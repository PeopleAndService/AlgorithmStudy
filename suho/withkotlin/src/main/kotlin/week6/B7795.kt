package week6

import java.util.StringTokenizer

/*
플랫폼 : 백준
문제번호 : 7795
문제제목 : 먹을 것인가 먹힐 것인가
난이도 : 실버 3
제한사항 : 1초/256MB
알고리즘 분류 : 정렬, 이분탐색, 투 포인터

알고리즘 설명
이분탐색 LowerBound를 썼으면 더 빠를 것 같은데 코틀린 컬렉션의 indexOfFirst를 쓰긴 했습니다.
b의 배열에서 현재 a 생명체의 크기보다 같거나 큰 첫번째 원소의 인덱스를 찾으면 된다 = LowerBound 찾는 것과 동일

채점 결과 : 972ms/43496KB
풀이 날짜 : 2022/02/25
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    repeat(br.readLine().toInt()) {
        val n: Int
        val m: Int
        with(StringTokenizer(br.readLine())) {
            n = nextToken().toInt()
            m = nextToken().toInt()
        }
        val a = with(StringTokenizer(br.readLine())) { IntArray(n) { nextToken().toInt() } }
        val b = with(StringTokenizer(br.readLine())) { IntArray(m) { nextToken().toInt() } }.sortedArray()
        val result = a.sumOf { aNum ->
            val temp = b.indexOfFirst { bNum -> bNum >= aNum }
            if (temp < 0) m else temp
        }
        bw.write("$result")
        bw.newLine()
    }
    bw.close()
    br.close()
}