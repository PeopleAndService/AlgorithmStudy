package baekjoon.topologicalsort_floydwashal

// 저울

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    val matrix = Array(n+1) { BooleanArray(n+1) }
    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        matrix[a][b] = true
    }

    for (k in 1 .. n) {
        matrix[k][k] = true

        for (i in 1 .. n) {
            for (j in 1 .. n) {
                if (matrix[i][k] && matrix[k][j]) {
                    matrix[i][j] = true
                }
            }
        }
    }

    for (i in 1 .. n) {
        var result = 0

        for (j in 1 .. n) {
            if (!matrix[i][j] && !matrix[j][i]) result++
        }

        println(result)
    }

}