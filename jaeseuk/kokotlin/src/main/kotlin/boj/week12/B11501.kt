package boj.week12

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

//  주식

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    repeat(br.readLine().toInt()) {
        val n = br.readLine().toInt()
        val prices = StringTokenizer(br.readLine()).run { LongArray(n) { nextToken().toLong() } }

        var answer = 0L
        var maxPrice = prices.last()

        for (i in prices.lastIndex - 1 downTo 0) {
            if (prices[i] < maxPrice) answer += maxPrice - prices[i]
            else maxPrice = prices[i]
        }

        bw.write("$answer")
        bw.newLine()
    }

    bw.flush()
    bw.close()
}