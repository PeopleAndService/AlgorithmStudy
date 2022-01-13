package boj.bronze

import java.io.BufferedWriter
import java.io.OutputStreamWriter

// A+B -8

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    for (i in 1..readLine()!!.toLong()) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        bw.write("Case #$i: $a + $b = ${a+b}\n")
    }

    bw.flush(); bw.close()
}