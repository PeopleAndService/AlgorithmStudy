package boj.code_plus2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

//  수 이어 쓰기 1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()

    var a = 1
    var b = 1

    var answer = 0

    while (b <= n) {
        b *= 10

        answer += if (b <= n) {
            a * (b - (b / 10))
        } else {
            a * (n - (b / 10))
        } + 1

        a++
    }

    bw.write("$answer")
    bw.flush()
    bw.close()
}