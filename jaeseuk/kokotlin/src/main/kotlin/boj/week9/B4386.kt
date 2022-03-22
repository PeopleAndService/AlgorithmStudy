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

//  별자리 만들기

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private var n = br.readLine().toInt()

private val edges = PriorityQueue<Triple<Double, Int, Int>>(compareBy { it.first })
private val parents = IntArray(n) { it }

fun main() {
    val stars = Array(n) { StringTokenizer(br.readLine()).run { nextToken().toDouble() to nextToken().toDouble() } }

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            val dist = sqrt(abs(stars[i].first - stars[j].first).pow(2) + abs(stars[i].second - stars[j].second).pow(2))
            edges.add(Triple(dist, i, j))
        }
    }

    var answer = 0.0

    while (edges.isNotEmpty()) {
        val (dist, a, b) = edges.poll()

        if (findParent(a) != findParent(b)) {
            answer += dist
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