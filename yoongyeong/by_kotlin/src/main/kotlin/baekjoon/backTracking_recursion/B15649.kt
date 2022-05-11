package baekjoon.backTracking_recursion

// N과 M (1)

private lateinit var array: IntArray
private lateinit var visited: BooleanArray
private val sb = StringBuilder()

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    array = IntArray(m); visited = BooleanArray(n)

    permutation(n, m)
    println(sb.toString())
}

private fun permutation(n: Int, m: Int, depth: Int = 0) {
    if (depth == m) {
        sb.append(array.joinToString(" ", postfix = "\n")); return
    }

    for (i in 0 until n) {
        if (!visited[i]) {
            visited[i] = true
            array[depth] = i + 1
            permutation(n, m, depth + 1)
            visited[i] = false
        }
    }
}