package boj.backtracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private var n = 0
private var m = 0

private lateinit var numbers: Array<String>
private val set = mutableSetOf<Int>()

fun main() {
    br.readLine().split(" ").run {
        n = first().toInt()
        m = last().toInt()
    }

    numbers = br.readLine().split(" ").sortedBy { it.toInt() }.toTypedArray()

    val arr = IntArray(m)

    comb(arr, 0)

    bw.flush()
    bw.close()
}

private fun comb(arr: IntArray, idx: Int) {
    if (idx == m) {
        bw.append(arr.joinToString(separator = " ", postfix = "\n"))
        return
    }

    for (i in 0 until n) {
        val num = numbers[i].toInt()

        if (num !in set) {
            arr[idx] = num
            set.add(num)
            comb(arr, idx + 1)
            set.remove(num)
        }
    }
}