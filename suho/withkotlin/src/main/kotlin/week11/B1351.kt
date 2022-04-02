package week11

import java.util.StringTokenizer
import kotlin.math.floor

/*
플랫폼 : 백준
문제번호 : 1351
문제제목 : 무한 수열
난이도 : 골드 5
제한사항 : 2초/128MB
알고리즘 분류 : DP, 자료 구조, 해시를 사용한 집합과 맵

알고리즘 설명
- 바텀 업 또는 탑 다운 방식으로 중간 결과를 메모이제이션해서 DP로 풀면된다.
- 배열을 사용하면 정수 인덱스 범위를 초과하기 때문에 해시 맵에 메모이제이션
1. 탑 다운 방식으로 재귀로 풀었음
2. 메모이제이션 값이 있는 경우 최적화

채점 결과 : 112ms/13756KB
풀이 날짜 : 2022/04/01
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private val map = mutableMapOf<Long, Long>()

private var p = 0
private var q = 0

fun main() {
    val n: Long
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toLong()
        p = nextToken().toInt()
        q = nextToken().toInt()
    }

    bw.write("${infSeq(n)}")
    bw.close()
    br.close()
}

private fun infSeq(n: Long): Long {
    if (n == 0L) return 1L
    if (map.containsKey(n)) return map.getValue(n)

    val nDivP = floor(n / p.toDouble()).toLong()
    val nDivQ = floor(n / q.toDouble()).toLong()

    map[n] = infSeq(nDivP) + infSeq(nDivQ)
    return map.getValue(n)
}