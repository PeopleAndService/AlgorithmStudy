package boj.backtracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private var n = 0
private var m = 0

private lateinit var numbers: SortedSet<String>

fun main() {
    br.readLine().split(" ").run {
        n = first().toInt()
        m = last().toInt()
    }

    numbers = br.readLine().split(" ").toSortedSet(compareBy { it.toInt() })

    val arr = IntArray(m)
    solution(arr, 0)

    bw.flush()
    bw.close()
}

private fun solution(arr: IntArray, idx: Int) {
    if (idx == m) {
        bw.append(arr.joinToString(separator = " ", postfix = "\n"))
        return
    }

    numbers.forEach {
        val num = it.toInt()

        if (idx == 0 || num >= arr[idx - 1]) {
            arr[idx] = num
            solution(arr, idx + 1)
            arr[idx] = 0
        }
    }
}