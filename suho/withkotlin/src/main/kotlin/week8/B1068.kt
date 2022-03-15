package week8

import java.util.StringTokenizer

/*
플랫폼 : 백준
문제번호 : 1068
문제제목 : 트리
난이도 : 골드 5
제한사항 : 2초/128MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, 트리, DFS

알고리즘 설명
각 노드의 부모 노드 번호를 담는 배열
한 노드 삭제 -> 얘를 루트로 하는 서브 트리가 삭제 -> 재귀로 삭제 -> 삭제된 노드의 부모는 Int.MIN_VALUE 로
DFS로 단말 노드의 수를 센다 -> 삭제된 노드가 아니고, 자신이 부모인 노드(= 자식 노드)가 없으면 리프 노드임

채점 결과 : 88ms/12400KB
풀이 날짜 : 2022/03/15
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val parent = IntArray(n)
    var root = 0
    with(StringTokenizer(br.readLine())) {
        repeat(n) {
            parent[it] = nextToken().toInt()
            if (parent[it] == -1) root = it
        }
    }
    val delNode = br.readLine().toInt()

    deleteNode(delNode, parent)
    bw.write("${dfs(root, parent, BooleanArray(n))}")
    bw.close()
    br.close()
}

private fun deleteNode(node: Int, parent: IntArray) {
    parent[node] = Int.MIN_VALUE
    for ((idx, p) in parent.withIndex()) {
        if (p == node) deleteNode(idx, parent)
    }
}

private fun dfs(cur: Int, parent: IntArray, visit: BooleanArray): Int {
    visit[cur] = true

    if (parent[cur] == Int.MIN_VALUE) return 0

    var count = 0
    var isTerminal = true
    for ((idx, p) in parent.withIndex()) {
        if (p == cur && !visit[idx]) {
            count += dfs(idx, parent, visit)
            isTerminal = false
        }
    }
    return if(isTerminal) 1 else count
}