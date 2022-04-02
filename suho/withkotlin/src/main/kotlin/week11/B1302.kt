package week11

/*
플랫폼 : 백준
문제번호 : 1302
문제제목 : 베스트셀러
난이도 : 실버 4
제한사항 : 2초/128MB
알고리즘 분류 : 자료 구조, 문자열, 정렬, 해시를 사용한 집합과 맵

알고리즘 설명
1. 맵에 책 카운트
2. 최대값을 찾고 사전순으로 제일 앞서는 책 제목 출력

채점 결과 : 144ms/18248KB
풀이 날짜 : 2022/04/02
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val map = mutableMapOf<String, Int>()
    repeat(n) {
        val book = br.readLine()
        map[book] = map.getOrDefault(book, 0) + 1
    }
    val max = map.values.maxOf { it }
    val answer = map.filter { it.value == max }.keys.sorted()[0]
    bw.write(answer)
    bw.close()
    br.close()
}