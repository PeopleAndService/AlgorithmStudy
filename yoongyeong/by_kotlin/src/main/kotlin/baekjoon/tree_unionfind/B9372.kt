package baekjoon.tree_unionfind

import java.util.*

// 상근이의 여행

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    repeat(br.readLine().toInt()) {
        val n: Int; val m: Int
        with (StringTokenizer(br.readLine())) {
            n = nextToken().toInt(); m = nextToken().toInt()
        }
        var cycle = 0
        val parents = IntArray(n+1) {it}
        for (i in 0 until m) {
            with(StringTokenizer(br.readLine())) {
                val parentA = parents.find(nextToken().toInt())
                val parentB = parents.find(nextToken().toInt())
                when {
                    parentA == parentB -> cycle++
                    parentA > parentB -> parents[parentA] = parentB
                    else ->  parents[parentB] = parentA
                }

            }
        }
        bw.write("${m-cycle}\n")
    }

    bw.close(); br.close()
}

private fun IntArray.find(x: Int): Int {
    if (this[x] != x) this[x] = this.find(this[x])
    return this[x]
}