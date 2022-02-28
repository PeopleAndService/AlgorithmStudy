package week6

import java.util.StringTokenizer

/*
플랫폼 : 백준
문제번호 : 10815
문제제목 : 숫자 카드
난이도 : 실버 4
제한사항 : 2초/256MB
알고리즘 분류 : 정렬, 이분탐색

알고리즘 설명
이분탐색 basic

채점 결과 : binarySearch 확장 함수 사용 - 1264ms/185756KB, 직접 구현 - 1276ms/186576KB
풀이 날짜 : 2022/02/27
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val cards = with(StringTokenizer(br.readLine())) { IntArray(n) { nextToken().toInt() }.sortedArray() }
    val m = br.readLine().toInt()
    with(StringTokenizer(br.readLine())) {
        repeat(m) {
//             bw.write("${if (cards.binarySearch(nextToken().toInt()) >= 0) 1 else 0} ")
            bw.write("${solution(cards, nextToken().toInt())} ")
        }
    }
    bw.close()
    br.close()
}

private fun solution(arr: IntArray, target: Int): Int {
    var start = 0
    var end = arr.lastIndex

    while (start <= end) {
        val mid = (start + end) / 2

        if (arr[mid] == target) {
            return 1
        } else if (arr[mid] < target) {
            start = mid + 1
        } else {
            end = mid - 1
        }
    }

    return 0
}