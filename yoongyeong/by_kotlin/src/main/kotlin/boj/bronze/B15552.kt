package boj.bronze

import java.io.BufferedWriter
import java.io.OutputStreamWriter

// 빠른 A+B

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    for (i in 1..readLine()!!.toLong()) bw.write("${readLine()!!.split(" ").map { it.toInt() }.let { it[0]+it[1] }} \n")
    bw.flush(); bw.close()
}