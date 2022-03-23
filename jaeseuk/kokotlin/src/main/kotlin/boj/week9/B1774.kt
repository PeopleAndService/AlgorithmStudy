package boj.week9

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue
import java.util.StringTokenizer
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

//  우주신과의 교감

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

    val pos = Array(n) { StringTokenizer(br.readLine()).run { nextToken().toInt() to nextToken().toInt() } }
    val edges = PriorityQueue<Triple<Double, Int, Int>>(compareBy { it.first })

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            val oa = abs(pos[i].first - pos[j].first).toDouble()
            val ob = abs(pos[i].second - pos[j].second).toDouble()
            val dist = sqrt(oa.pow(2) + ob.pow(2))

            edges.add(Triple(dist, i + 1, j + 1))
        }
    }

    repeat(m) {
        StringTokenizer(br.readLine()).run { union(nextToken().toInt(), nextToken().toInt()) }
    }

    var answer = 0.0

    while (edges.isNotEmpty()) {
        val (dist, a, b) = edges.poll()

        if (findParent(a) != findParent(b)) {
            answer += dist
            union(a, b)
        }
    }

    bw.append(String.format("%.2f", answer))
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