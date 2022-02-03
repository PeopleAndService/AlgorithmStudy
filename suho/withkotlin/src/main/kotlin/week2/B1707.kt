package week2

import java.util.*

/*
플랫폼 : 백준
문제번호 : 1707
문제제목 : 이분 그래프
난이도 : 골드 4
제한사항 : 2초/256MB
알고리즘 분류 : 그래프 이론, 그래프 탐색, DFS, BFS

알고리즘 설명
2개의 그룹으로 정해져있다는 점을 제외하면 인접된 칸을 서로 다른 색으로 칠하는 알고리즘과 비슷
1. 2개의 그룹으로 정해져 있다는 점
    -> 간선의 끝 점의 그룹이 서로 달라야한다. = 어떤 노드에 대해서 인접한 정점들 중에 같은 그룹의 노드가 하나라도 있으면 안됌
2. 그래프 순회하면서 인접 정점끼리는 다른 그룹(1, 2 중 하나)으로 표시해준다. -> dfs() 함수
3. 순회가 끝나면 1번 조건을 확인해서 정답 출력 -> checkGroup() 함수

채점 결과 : 1352ms/309768KB
풀이 날짜 : 2022/02/03
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private lateinit var graph: Array<MutableList<Int>>
private lateinit var set: IntArray

private var v = 0
private var e = 0

fun main() {
    repeat(br.readLine().toInt()) {
        StringTokenizer(br.readLine()).run {
            v = nextToken().toInt()
            e = nextToken().toInt()
        }
        graph = Array(v) { mutableListOf() }
        set = IntArray(v)
        repeat(e) {
            StringTokenizer(br.readLine()).run {
                val a = nextToken().toInt() - 1
                val b = nextToken().toInt() - 1
                graph[a].add(b)
                graph[b].add(a)
            }
        }
        repeat(v) { if (set[it] == 0) dfs(it, 1) }
        bw.write("${checkSet()}\n")
    }
    bw.close()
    br.close()
}

private fun dfs(vertex: Int, group: Int) {
    set[vertex] = group
    graph[vertex].filter { set[it] == 0 }.forEach { dfs(it, if (group == 1) 2 else 1) }
}

private fun checkSet(): String {
    repeat(v) { vertex ->
       if (graph[vertex].any { set[vertex] == set[it] }) return "NO"
    }
    return "YES"
}