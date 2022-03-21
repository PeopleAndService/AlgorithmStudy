package boj.week9

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

//  최소 스패닝 트리

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private var v = 0
private var e = 0

private lateinit var parents: IntArray

fun main() {
    StringTokenizer(br.readLine()).run {
        v = nextToken().toInt()
        e = nextToken().toInt()
    }

    parents = IntArray(v + 1) { it }

    val edges = Array(e) {
        StringTokenizer(br.readLine()).run {
            val a = nextToken().toInt()
            val b = nextToken().toInt()
            val c = nextToken().toInt()

            Triple(c, a, b)
        }
    }.sortedArrayWith(compareBy { it.first })

    var answer = 0

    for ((c, a, b) in edges) {
        if (findParent(a) != findParent(b)) {
            answer += c
            union(a, b)
        }
    }

    bw.append("$answer")
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

    if (ap > bp) parents[ap] = bp
    else parents[bp] = ap
}