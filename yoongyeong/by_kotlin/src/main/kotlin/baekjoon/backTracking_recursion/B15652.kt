package baekjoon.backTracking_recursion

// N과 M (4)

private val sb = StringBuilder()
private lateinit var array: IntArray

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    array = IntArray(m)

    repeatCombination(n, m)
    print(sb.toString())
}

private fun repeatCombination(n: Int, m: Int, depth: Int = 0, index: Int = 1) {
    if (depth == m) {
        sb.append(array.joinToString(" ", postfix = "\n")); return
    }

    for (i in index .. n) {
        array[depth] = i
        repeatCombination(n, m, depth + 1, i)
    }
}