package boj.code_plus2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

//  카잉 달력

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    repeat(br.readLine().toInt()) {
        val (M, N, x, y) = br.readLine().split(" ").map { it.toInt() }

        val lcm = M * N / gcd(M, N)
        var k = x

        while (k <= lcm) {
            if ((k - y) % N == 0) break

            k += M
        }

        bw.write("${if (k > lcm) -1 else k}")
        bw.newLine()
    }

    bw.flush()
    bw.close()
}

private fun gcd(x: Int, y: Int): Int {
    var gcd = 1

    for (i in 2..minOf(x, y)) {
        if (x % i == 0 && y % i == 0) {
            gcd = i
            break
        }
    }

    return gcd
}