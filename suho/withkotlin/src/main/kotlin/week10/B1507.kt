package week10

import java.util.StringTokenizer

/*
플랫폼 : 백준
문제번호 : 1507
문제제목 : 궁금한 민호
난이도 : 골드 3
제한사항 : 2초/128MB
알고리즘 분류 : 그래프 이론, 플로이드-와샬

알고리즘 설명
1. 플로이드 결과 그래프를 한 번더 플로이드해서 원래 그래프를 구할 수 있다.
2. floyd[i][j] > floyd[i][k] + floyd[k][j] 인 경우 최단 경로가 한 번 더 갱신되야하기 때문에 불가능한 경우 -> -1
3. floyd[i][j] == floyd[i][k] + floyd[k][j] 가 true 인 경우 원래 그래프에서 i -> k, k -> j로 가는 간선을 사용한 것이므로
i -> j로 가는 간선을 지움

채점 결과 : 92ms/12460KB
풀이 날짜 : 2022/03/28
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val inst = B1507(n)
    inst.input()
    val answer = inst.solution()
    bw.write("$answer")
    bw.close()
    br.close()
}

class B1507(private val n: Int) {
    private val floydResult = Array(n) { IntArray(n) }
    private val graph = Array(n) { IntArray(n) }

    fun input() {
        repeat(n) { row ->
            with(StringTokenizer(br.readLine())) {
                repeat(n) { col ->
                    floydResult[row][col] = nextToken().toInt()
                    graph[row][col] = floydResult[row][col]
                }
            }
        }
    }

    private fun reverseFloyd(): Boolean {
        for (k in 0 until n) {
            for (i in 0 until n) {
                for (j in 0 until n) {
                    when {
                        i == j || i == k || k == j -> continue
                        floydResult[i][j] > floydResult[i][k] + floydResult[k][j] -> return false
                        floydResult[i][j] == floydResult[i][k] + floydResult[k][j] -> graph[i][j] = Int.MAX_VALUE
                    }
                }
            }
        }

        return true
    }

    fun solution(): Int {
        return if (reverseFloyd()) {
            var sum = 0
            for (i in 0 until n) {
                for (j in i + 1 until n) {
                    sum += if (graph[i][j] == Int.MAX_VALUE) 0 else graph[i][j]
                }
            }
            sum
        } else {
            -1
        }
    }
}