package boj.week9

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

//  친구비

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private var n = 0
private var m = 0
private var k = 0

private lateinit var costs: IntArray
private lateinit var parents: IntArray

fun main() {
    StringTokenizer(br.readLine()).run {
        n = nextToken().toInt()
        m = nextToken().toInt()
        k = nextToken().toInt()
    }

    costs = StringTokenizer(br.readLine()).run { IntArray(n) { nextToken().toInt() } }
    parents = IntArray(n + 1) { it }

    repeat(m) {
        StringTokenizer(br.readLine()).run { union(nextToken().toInt(), nextToken().toInt()) }
    }

    val needs = mutableSetOf<Int>()

    for (i in 1..n) {
        needs.add(findParent(i))
    }

    needs.sumOf { costs[it - 1] }.let { sum ->
        if (sum <= k) bw.append("$sum")
        else bw.append("Oh no")
    }

    bw.flush()
    bw.close()
}

private fun findParent(x: Int): Int {
    if (parents[x] != x) parents[x] = findParent(parents[x])
    return parents[x]
}

private fun union(a: Int, b: Int) {
    val ap = findParent(a)
    val bp = findParent(b)

    if (costs[ap - 1] > costs[bp - 1]) parents[ap] = bp
    else parents[bp] = ap
}