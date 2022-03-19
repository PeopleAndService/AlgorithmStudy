package week9

import java.util.*

/*
플랫폼 : 백준
문제번호 : 11437
문제제목 : LCA
난이도 : 골드 3
제한사항 : 3초/256MB
알고리즘 분류 : 트리, 최소 공통 조상

알고리즘 설명
1. DFS로 부모 노드와 레벨에 대한 정보를 채운다.
2. lca는 계속 부모 노드를 타고 가면서 동일한 부모 노드가 나올 때 까지 반복해서 찾는다.
-> 시작 깊이를 맞춰줘야 동시에 올라갈 수 있음. 낮은 레벨의 노드를 위로 올려준다.

채점 결과 : 1248ms/41788KB
풀이 날짜 : 2022/03/19
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val inst = B11437(n)
    inst.input()
    inst.dfs(1, 1, 0)
    repeat(br.readLine().toInt()) {
        val a: Int
        val b: Int
        with(StringTokenizer(br.readLine())) {
            a = nextToken().toInt()
            b = nextToken().toInt()
        }
        bw.write("${inst.lca(a, b)}")
        bw.newLine()
    }
    bw.close()
    br.close()
}

class B11437(private val n: Int) {
    private val tree = Array(n + 1) { mutableListOf<Int>() }
    private val parents = IntArray(n + 1)
    private val depths = IntArray(n + 1)

    fun input() {
        repeat(n - 1) {
            with(StringTokenizer(br.readLine())) {
                val a = nextToken().toInt()
                val b = nextToken().toInt()
                tree[a].add(b)
                tree[b].add(a)
            }
        }
    }

    fun dfs(cur: Int, level: Int, parent: Int) {
        parents[cur] = parent
        depths[cur] = level
        for (child in tree[cur]) {
            if (child != parent) {
                dfs(child, level + 1, cur)
            }
        }
    }

    fun lca(a: Int, b: Int): Int {
        var low = a
        var high = b
        if (depths[low] < depths[high]) {
            high = low.also { low = high }
        }

        while (depths[low] != depths[high]) {
            low = parents[low]
        }

        while (low != high) {
            low = parents[low]
            high = parents[high]
        }

        return low
    }
}