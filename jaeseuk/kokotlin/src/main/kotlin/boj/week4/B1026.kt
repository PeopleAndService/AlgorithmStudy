package boj.week4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()

    val a = br.readLine().split(" ").sortedByDescending { it.toInt() }
    val b = br.readLine().split(" ").sortedBy { it.toInt() }

    bw.append("${a.zip(b).sumOf { it.first.toInt() * it.second.toInt() }}")
    bw.flush()
    bw.close()
}