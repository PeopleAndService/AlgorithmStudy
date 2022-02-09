package backTracking_recursion

import java.io.*

// N과 M (5)

private lateinit var list: List<String>
private lateinit var array: IntArray
private lateinit var visited: BooleanArray
private val br = BufferedReader(InputStreamReader(System.`in`))
private val sb = StringBuilder()

fun main() {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    list = br.readLine().split(" ").sortedBy { it.toInt() }
    array = IntArray(m); visited = BooleanArray(n)

    permutation(n, m)
    print(sb.toString())
}

private fun permutation(n: Int, m: Int, depth: Int = 0) {
    if (depth == m) {
        sb.append(array.joinToString(" ", postfix = "\n")); return
    }

    list.forEachIndexed { index, t ->
        if (!visited[index]) {
            visited[index] = true
            array[depth] = t.toInt()
            permutation(n, m, depth + 1)
            visited[index] = false
        }
    }
}