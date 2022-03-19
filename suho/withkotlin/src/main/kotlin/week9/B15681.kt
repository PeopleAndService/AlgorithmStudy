package week9

import java.util.StringTokenizer

/*
플랫폼 : 백준
문제번호 : 15681
문제제목 : 트리와 쿼리
난이도 : 골드 5
제한사항 : 1초/128MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, 트리, DFS, 트리 DP, DP

알고리즘 설명
트리 DP와 DFS
루트 노드부터 DFS 시작 -> 각 노드에서의 자신을 루트로 하는 서브 트리의 정점 수를 계산할 수 있음(만약 단말 노드라면 1일 것임)

채점 결과 : 648ms/86984KB
풀이 날짜 : 2022/03/18
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n: Int
    val r: Int
    val q: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        r = nextToken().toInt()
        q = nextToken().toInt()
    }

    val tree = Array(n + 1) { mutableListOf<Int>() }.apply {
        repeat(n - 1) {
            with(StringTokenizer(br.readLine())) {
                val u = nextToken().toInt()
                val v = nextToken().toInt()
                this@apply[u].add(v)
                this@apply[v].add(u)
            }
        }
    }

    val dp = IntArray(n+1)
    val visit = BooleanArray(n+1)
    dfs(r, tree, dp, visit)

    repeat(q) {
        val input = br.readLine().toInt()
        bw.write("${dp[input]}\n")
    }
    bw.close()
    br.close()
}

private fun dfs(node: Int, tree: Array<MutableList<Int>>, dp: IntArray, visit: BooleanArray): Int {
    if (dp[node] != 0) return node

    visit[node] = true

    var count = 1
    for (child in tree[node]) {
        if (!visit[child]) count += dfs(child, tree, dp, visit)
    }

    dp[node] = count
    return dp[node]
}