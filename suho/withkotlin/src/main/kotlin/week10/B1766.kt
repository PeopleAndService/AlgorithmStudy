package week10

import java.util.PriorityQueue
import java.util.StringTokenizer

/*
플랫폼 : 백준
문제번호 : 1766
문제제목 : 문제집
난이도 : 골드 2
제한사항 : 2초/128MB
알고리즘 분류 : 그래프 이론, 자료 구조, 우선순위 큐, 위상 정렬

알고리즘 설명
1. 먼저 풀어야 하는 문제가 있으므로 위상 정렬 수행
2. 먼저 풀어야 하는 문제가 있으면 먼저 푸는 데, 그렇지 않은 경우 난이도가 낮은 문제를 먼저 풀어야함 -> 숫자가 작은 문제
3. 일반 큐 대신 우선순위 큐 사용

채점 결과 : 500ms/50480KB
풀이 날짜 : 2022/03/29
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

    val graph = Array(n + 1) { mutableListOf<Int>() }
    val inDegree = IntArray(n + 1)
    repeat(m) {
        with(StringTokenizer(br.readLine())) {
            val a = nextToken().toInt()
            val b = nextToken().toInt()
            graph[a].add(b)
            inDegree[b]++
        }
    }

    val pq = PriorityQueue<Int>()
    for (i in 1..n) {
        if (inDegree[i] == 0) {
            pq.offer(i)
        }
    }

    while (pq.isNotEmpty()) {
        val prob = pq.poll()

        for (next in graph[prob]) {
            inDegree[next]--

            if (inDegree[next] == 0) {
                pq.offer(next)
            }
        }

        bw.write("$prob ")
    }

    bw.close()
    br.close()
}