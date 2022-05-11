package baekjoon.backTracking_recursion

import java.io.BufferedReader
import java.io.InputStreamReader

// N과 M (8)

private val sb = StringBuilder()
private val br = BufferedReader(InputStreamReader(System.`in`))
private lateinit var array: IntArray
private lateinit var list: List<String>

fun main() {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    list = br.readLine().split(" ").sortedBy { it.toInt() }
    array = IntArray(m)

    repeatCombination(n, m)
    print(sb.toString())
}

private fun repeatCombination(n: Int, m: Int, depth: Int = 0, index: Int = 0) {
    if (depth == m) {
        sb.append(array.joinToString(" ", postfix = "\n")); return
    }

    for (i in index until  n) {
        array[depth] = list[i].toInt()
        repeatCombination(n, m, depth + 1, i)
    }
}