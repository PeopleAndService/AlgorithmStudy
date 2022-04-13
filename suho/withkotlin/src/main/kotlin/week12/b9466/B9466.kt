package baekjoon.b9466

import java.util.*

/*
플랫폼 : 백준
문제번호 : 9466
문제제목 : 텀 프로젝트
난이도 : 골드 3
제한사항 : 3초/256MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, 깊이 우선 탐색

알고리즘 설명
위상정렬 사용 또는 DFS로 풀이 가능

채점 결과 : 3224ms/333476KB
풀이 날짜 : 2022/04/10
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    repeat(br.readLine().toInt()) { _ ->
        val n = br.readLine().toInt()
        val graph = Array(n + 1) { mutableListOf<Int>() }
        val inDegree = IntArray(n + 1)
        with(StringTokenizer(br.readLine())) {
            for (i in 1..n) {
                val temp = nextToken().toInt()
                graph[i].add(temp)
                inDegree[temp]++
            }
        }

        val queue = LinkedList<Int>()
        for (i in 1..n) {
            if (inDegree[i] == 0) {
                queue.offer(i)
            }
        }

        while (!queue.isEmpty()) {
            val cur = queue.poll()

            for (next in graph[cur]) {
                inDegree[next]--

                if (inDegree[next] == 0) {
                    queue.offer(next)
                }
            }
        }

        var answer = 0
        for (i in 1..n) {
            if (inDegree[i] == 0) answer++
        }

        bw.write("$answer")
        bw.newLine()
    }
    bw.close()
    br.close()
}