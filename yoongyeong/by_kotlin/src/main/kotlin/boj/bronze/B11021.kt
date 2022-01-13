package boj.bronze

import java.io.BufferedWriter
import java.io.OutputStreamWriter

// A+B -7

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    for (i in 1..readLine()!!.toLong())
        bw.write("Case #$i: ${readLine()!!.split(" ").map { it.toInt() }.let { it[0]+it[1] }} \n")
    bw.flush(); bw.close()
}