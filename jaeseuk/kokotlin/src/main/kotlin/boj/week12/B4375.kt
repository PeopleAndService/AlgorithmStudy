package boj.week12

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.math.BigInteger

//  1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var number: BigInteger
    var answer: Int

    while (true) {
        val n = br.readLine()?.toBigInteger() ?: break
        number = BigInteger.ZERO
        answer = 1

        while (true) {
            number = number.multiply(BigInteger.TEN).add(BigInteger.ONE)

            if (number.mod(n) == BigInteger.ZERO) {
                bw.write("$answer")
                bw.newLine()
                break
            }

            answer++
        }
    }

    bw.flush()
    bw.close()
}