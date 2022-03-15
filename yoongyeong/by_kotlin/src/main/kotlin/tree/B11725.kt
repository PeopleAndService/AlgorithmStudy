package tree

import java.util.StringTokenizer

// 트리의 부모 찾기

private lateinit var trees: Array<MutableList<Int>>

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    trees = Array(n+1) { mutableListOf() }

    repeat(n-1) {
        with(StringTokenizer(br.readLine())) {
            val a = nextToken().toInt(); val b = nextToken().toInt()
            trees[a].add(b); trees[b].add(a)
        }
    }

    val parents = IntArray(n+1)

    dfs(parents, n, 1, 0)

    for (i in 2 .. n) println(parents[i])
}

private fun dfs(parents: IntArray, n: Int, start: Int, parent: Int) {
    parents[start] = parent
    for (node in trees[start]) if (node != parent) dfs(parents, n, node, start)
}