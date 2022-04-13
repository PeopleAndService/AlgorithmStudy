package boj.week12

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

//  주유소

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()

    val lengths = StringTokenizer(br.readLine()).run { IntArray(n - 1) { nextToken().toInt() } }
    val prices = StringTokenizer(br.readLine()).run { IntArray(n) { nextToken().toInt() } }

    var answer = 0L
    var minPrice = prices[0]

    repeat(n - 1) {
        minPrice = minOf(minPrice, prices[it])
        answer += minPrice.toLong() * lengths[it]
    }

    bw.write("$answer")
    bw.flush()
    bw.close()
}