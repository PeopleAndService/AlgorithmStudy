package boj.week12

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

//  약수

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()

    var minA = Int.MAX_VALUE
    var maxA = Int.MIN_VALUE

    with(StringTokenizer(br.readLine())) {
        repeat(n) {
            val num = nextToken().toInt()
            minA = minOf(minA, num)
            maxA = maxOf(maxA, num)
        }
    }

    bw.write("${minA * maxA}")
    bw.flush()
    bw.close()
}