package boj.week4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val pq = PriorityQueue<Long>()

    br.readLine().split(" ").forEach { pq.add(it.toLong()) }

    repeat(m) {
        val result = pq.poll() + pq.poll()
        pq.add(result)
        pq.add(result)
    }

    bw.append("${pq.sum()}")
    bw.flush()
    bw.close()
}