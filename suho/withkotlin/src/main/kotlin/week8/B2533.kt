package week8

import java.util.StringTokenizer

/*
플랫폼 : 백준
문제번호 : 2533
문제제목 : 사회망 서비스(SNS)
난이도 : 골드 3
제한사항 : 3초/256MB
알고리즘 분류 : DP, 트리, 트리 DP

알고리즘 설명
트리 DP 문제
노드는 얼리어답터가 될 수도, 안 될 수도 있음
dp[n][0]: n번째 노드가 얼리어답터가 아닌경우
dp[n][1]: n번째 노드가 얼리어답터인 경우
부모가 얼리어답터가 아닌 경우 자식은 모두 얼리어답터여야 한다. -> dp[n][0] += dp[child][1]
부모가 얼리어답터인 경우 자식은 얼리어답터일 수도 아닐 수도 있음 -> dp[n][1] += min(dp[child][0], dp[child][1])
깊이 우선 탐색 -> dp 테이블 갱신

채점 결과 : 2336ms/417240KB
풀이 날짜 : 2022/03/16
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val graph = Array(n + 1) { mutableListOf<Int>() }.apply {
        repeat(n - 1) {
            with(StringTokenizer(br.readLine())) {
                val u = nextToken().toInt()
                val v = nextToken().toInt()
                this@apply[u].add(v)
                this@apply[v].add(u)
            }
        }
    }
    val dp = Array(n + 1) { IntArray(2) }
    val visit = BooleanArray(n + 1)
    dfs(1, graph, visit, dp)

    bw.write("${minOf(dp[1][0], dp[1][1])}")
    bw.close()
    br.close()
}

private fun dfs(node: Int, graph: Array<MutableList<Int>>, visit: BooleanArray, dp: Array<IntArray>) {
    visit[node] = true
    dp[node][0] = 0
    dp[node][1] = 1

    for (child in graph[node]) {
        if (!visit[child]) {
            dfs(child, graph, visit, dp)
            dp[node][0] += dp[child][1]
            dp[node][1] += minOf(dp[child][0], dp[child][1])
        }
    }
}
