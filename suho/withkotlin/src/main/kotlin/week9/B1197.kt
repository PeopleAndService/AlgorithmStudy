package week9

import java.util.*

/*
플랫폼 : 백준
문제번호 : 1197
문제제목 : 최소 스패닝 트리
난이도 : 골드 4
제한사항 : 1초/128MB
알고리즘 분류 : 그래프 이론, 최소 스패닝 트리

알고리즘 설명
크루스칼 알고리즘

채점 결과 : 700ms/98298KB
풀이 날짜 : 2022/03/22
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val inst = with(StringTokenizer(br.readLine())) {
        B1197(nextToken().toInt(), nextToken().toInt())
    }
    inst.input()
    bw.write("${inst.solution()}")
    bw.close()
    br.close()
}

private class B1197(v: Int, private val e: Int) {
    private data class Edge(
        val s: Int,
        val e: Int,
        val w: Int
    )

    private val edges = mutableListOf<Edge>()
    private val parents = IntArray(v + 1) { it }

    fun input() {
        repeat(e) {
            with(StringTokenizer(br.readLine())) {
                val a = nextToken().toInt()
                val b = nextToken().toInt()
                val w = nextToken().toInt()

                edges.add(Edge(a, b, w))
            }
        }
    }

    fun solution(): Int {
        edges.sortBy { it.w }

        var sum = 0
        for ((a, b, w) in edges) {
            if (find(a) != find(b)) {
                sum += w
                union(a, b)
            }
        }
        return sum
    }

    private fun find(x: Int): Int {
        return if (x == parents[x]) x
        else {
            parents[x] = find(parents[x])
            parents[x]
        }
    }

    private fun union(a: Int, b: Int) {
        val aP = find(a)
        val bP = find(b)

        if (aP != bP) {
            if (aP < bP) parents[bP] = aP
            else parents[aP] = bP
        }
    }
}