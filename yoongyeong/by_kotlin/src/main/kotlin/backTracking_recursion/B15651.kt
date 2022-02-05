package backTracking_recursion

// N과 M (3)

private val sb = StringBuilder()
private lateinit var array: IntArray

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    array = IntArray(m)

    repeatPermutation(n, m)
    print(sb.toString())
}

private fun repeatPermutation(n: Int, m: Int, depth: Int = 0) {
    if (depth == m) {
        sb.append(array.joinToString(" ", postfix = "\n")); return
    }

    for (i in 1..n) {
        array[depth] = i
        repeatPermutation(n, m, depth + 1)
    }
}