package boj.week12

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

//  약수의 합 2

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toLong()

    bw.write("${(1..n).sumOf { it * (n / it) }}")
    bw.flush()
    bw.close()
}