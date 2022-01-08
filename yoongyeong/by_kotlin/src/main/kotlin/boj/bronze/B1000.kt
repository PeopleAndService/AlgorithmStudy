package boj.bronze

// A+B

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    bw.write("${n+m}")
    bw.flush()
    bw.close()
}

private fun solution() = println(readLine()!!.split(" ").map { it.toInt() }.sum())