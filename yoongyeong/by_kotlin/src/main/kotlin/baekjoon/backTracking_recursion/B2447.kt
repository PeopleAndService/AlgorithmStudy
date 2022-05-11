package baekjoon.backTracking_recursion

// 별 찍기 - 10

private val sb = StringBuilder()

fun main() {
    val n = readLine()!!.toInt()

    for (i in 0 until n) {
        for (j in 0 until n) {
            stars(i, j, n / 3)
        }
        sb.append("\n")
    }

    print(sb.toString())
}

private fun stars(i: Int, j: Int, num: Int) {
    if ((i / num) % 3 == 1 && (j / num) % 3 == 1) sb.append(" ")
    else if (num / 3 == 0) sb.append("*")
    else stars(i, j, num / 3)
}