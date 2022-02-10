package boj.math

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.math.BigInteger

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    br.readLine().split(" ").run {
        bw.append("${BigInteger(first()).modPow(BigInteger(get(1)), BigInteger(last()))}")
        bw.flush()
        bw.close()
    }
}
