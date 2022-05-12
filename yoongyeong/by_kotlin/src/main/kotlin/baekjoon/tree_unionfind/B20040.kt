package baekjoon.tree_unionfind

import java.util.StringTokenizer

// 사이클 게임

private val br = System.`in`.bufferedReader()
private lateinit var parents: IntArray

fun main() {
    val n: Int; val m: Int
    var answer = 0
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt(); m = nextToken().toInt()
    }
    parents = IntArray(n) {it}

    for (time in 1 .. m) {
        with(StringTokenizer(br.readLine())) {
            val parentA = find(nextToken().toInt())
            val parentB = find(nextToken().toInt())

            if (parentA == parentB && answer == 0) answer = time
            else union(parentA, parentB)
        }
    }

    println(answer)
}

private fun union(parentA: Int, parentB: Int) {
    if (parentA > parentB) parents[parentA] = parentB
    else parents[parentB] = parentA
}

private fun find(x: Int): Int {
    if (parents[x] != x) parents[x] = find(parents[x])
    return parents[x]
}