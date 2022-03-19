package boj.week9

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

//  집합의 표현

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private var n = 0
private var m = 0

private lateinit var parents: IntArray

fun main() {
    StringTokenizer(br.readLine()).run {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }

    parents = IntArray(n + 1) { it }

    repeat(m) {
        val (op, a, b) = br.readLine().split(" ").map { it.toInt() }

        if (op == 0) {
            union(a, b)
        } else {
            bw.append(if (findParent(a) == findParent(b)) "YES" else "NO")
            bw.newLine()
        }
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

    if (ap > bp) parents[ap] = bp
    else parents[bp] = ap
}