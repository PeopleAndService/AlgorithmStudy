package week10

import java.util.*

/*
플랫폼 : 백준
문제번호 : 11780
문제제목 : 플로이드 2
난이도 : 골드 2
제한사항 : 1초/256MB
알고리즘 분류 : 그래프 이론, 플로이드

알고리즘 설명
1. 플로이드 수행
2. i -> k -> j 로 가는 경로로 갱신되었다면 path[i][j]에 path[k][j]를 저장
-> path 배열에는 해당 정점 경로에 이전 방문 정점 숫자가 들어간다.

채점 결과 : 644ms/65244KB
풀이 날짜 : 2022/03/31
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private const val MAX = 10_000_001

fun main() {
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val graph = Array(n + 1) { IntArray(n + 1) { MAX } }
    val path = Array(n + 1) { IntArray(n + 1) { -1 } }

    for (i in 1..n) {
        graph[i][i] = 0
    }

    repeat(m) {
        with(StringTokenizer(br.readLine())) {
            val a = nextToken().toInt()
            val b = nextToken().toInt()
            val c = nextToken().toInt()

            graph[a][b] = minOf(graph[a][b], c)
            path[a][b] = a
        }
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                when {
                    i == j || i == k || k == j -> continue
                    graph[i][j] > graph[i][k] + graph[k][j] -> {
                        graph[i][j] = graph[i][k] + graph[k][j]
                        path[i][j] = path[k][j]
                    }
                }
            }
        }
    }

    for (i in 1..n) {
        bw.write(graph[i].drop(1).joinToString(" ") { if (it == MAX) "0" else "$it" })
        bw.newLine()
    }

    for (i in 1..n) {
        for (j in 1..n) {
            if (path[i][j] == -1) {
                bw.write("0")
            } else {
                val paths = LinkedList<Int>()
                var prev = j
                paths.add(j)

                while (path[i][prev] != i) {
                    prev = path[i][prev]
                    paths.add(0, prev)
                }

                paths.add(0, i)
                bw.write("${paths.size} ${paths.joinToString(" ")}")
            }
            bw.newLine()
        }
    }

    bw.close()
    br.close()
}