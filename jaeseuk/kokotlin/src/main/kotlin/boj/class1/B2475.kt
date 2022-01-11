package boj.class1

import java.io.*
import kotlin.math.pow

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    bw.write("${br.readLine().split(' ').sumOf { it.toDouble().pow(2).toInt() } % 10}")
    bw.flush()
    bw.close()
}

fun solution() {
    println(readLine()!!.split(' ').sumOf { it.toDouble().pow(2).toInt() } % 10)
}