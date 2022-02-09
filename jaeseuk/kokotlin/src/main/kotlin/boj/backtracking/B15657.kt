package boj.backtracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private var n = 0
private var m = 0

private lateinit var numbers: List<String>

fun main() {
    br.readLine().split(" ").run {
        n = first().toInt()
        m = last().toInt()
    }

    numbers = br.readLine().split(" ").sortedBy { it.toInt() }

    val arr = IntArray(m)
    solution(0, arr, 0)

    bw.flush()
    bw.close()
}

private fun solution(start: Int, arr: IntArray, idx: Int) {
    if (idx == m) {
        bw.append(arr.joinToString(separator = " ", postfix = "\n"))
        return
    }

    for (i in start until n) {
        val num = numbers[i].toInt()

        arr[idx] = num
        solution(i, arr, idx + 1)
        arr[idx] = 0
    }
}