package baekjoon.minimumspaningtree

import java.util.PriorityQueue
import java.util.StringTokenizer
import kotlin.math.*

// 별자리 만들기

private val br = System.`in`.bufferedReader()
private val n = br.readLine().toInt()

private val pq = PriorityQueue<Triple<Double, Int, Int>> (compareBy { it.first })
private val parents = IntArray(n) {it}

fun main() {
    val stars = Array(n) { with(StringTokenizer(br.readLine())) {Pair(nextToken().toDouble(), nextToken().toDouble())} }

    for (i in 0 until n) {
        for (j in i+1 until n) {
            val distance = sqrt(abs(stars[i].first - stars[j].first).pow(2) +
                abs(stars[i].second - stars[j].second).pow(2))
            pq.add(Triple(distance, i, j))
        }
    }

    var answer = 0.0

    while (pq.isNotEmpty()) {
        val (distance, a, b) = pq.poll()

        if (find(a) != find(b)) {
            answer += distance
            union(a, b)
        }
    }

    println("%.2f".format(answer))

}

private fun union(a: Int, b: Int){
    val aParent = find(a)
    val bParent = find(b)
    if (aParent > bParent) parents[aParent] = bParent
    else parents[bParent] = aParent
}

private fun find(x: Int): Int {
    var parent = parents[x]
    while (parent != parents[parent]) parent = parents[parent]
    return parent
}