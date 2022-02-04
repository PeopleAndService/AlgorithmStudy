package backTracking_recursion

import java.io.*
import kotlin.math.pow

// 하노이 탑 이동 순서

val bw = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val n = readLine()!!.toInt()
    bw.append("${2.0.pow(n).toInt() -1}\n")
    hanoi(n, 1, 3, 2)
    bw.close()
}

private fun hanoi(n: Int, start: Int, end: Int, via: Int) {
    if (n == 1) bw.append("$start $end\n")
    else {
        hanoi(n-1, start, via, end)
        bw.append("$start $end\n")
        hanoi(n-1, via, end, start)
    }
}
