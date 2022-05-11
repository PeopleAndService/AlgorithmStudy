package baekjoon.backTracking_recursion

// N과 M 2

private lateinit var array: IntArray
private val sb = StringBuilder()

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    array = IntArray(m)

    combination(n, m)
    print(sb.toString())
}

private fun combination(n: Int, m: Int, depth: Int = 0, index: Int = 1) {
    if (depth == m) {
        sb.append(array.joinToString(" ", postfix = "\n")); return
    }

    for (i in index .. n) {
        if (depth == 0 || i > array[depth-1]) {
            array[depth] = i
            combination(n, m, depth+1, index+1)
        }
    }
}