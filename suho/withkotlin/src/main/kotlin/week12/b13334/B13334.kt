package baekjoon.b13334

import java.util.*

/*
플랫폼 : 백준
문제번호 : 13334
문제제목 : 철로
난이도 : 골드 2
제한사항 : 1초/512MB
알고리즘 분류 : 자료 구조, 정렬, 스위핑, 우선순위 큐

알고리즘 설명
1. 입력을 왼쪽 끝 점 - 오른쪽 끝 점 형태로 넣고
2. 오른쪽 끝 점을 기준으로 정렬, 같은 경우 왼쪽 끝 점이 작은 순으로
3. 라인을 하나씩 보면서 길이가 d이하이면 우선순위 큐에 왼쪽 끝 점을 넣는다.
4. 우선순위 큐에 원소가 존재한다면 길이를 넘어가는 왼쪽 끝 점을 모두 빼준다.
5. 우선순퀴 큐의 크기로 정답 갱신

채점 결과 : 844ms/55460KB
풀이 날짜 : 2022/04/11
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val lines = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        with(StringTokenizer(br.readLine())) {
            val a = nextToken().toInt()
            val b = nextToken().toInt()

            lines.add(minOf(a, b) to maxOf(a, b))
        }
    }
    val d = br.readLine().toInt()

    lines.sortWith(compareBy({ it.second }, { it.first }))
    val pq = PriorityQueue<Int>()
    var answer = 0
    lines.forEach {
        if (it.second - it.first <= d) pq.offer(it.first)
        else return@forEach

        while (pq.isNotEmpty()) {
            val front = pq.peek()
            if (it.second - front > d) pq.poll()
            else break
        }

        answer = maxOf(answer, pq.size)
    }

    bw.write("$answer")
    bw.close()
    br.close()
}