package baekjoon.twopointer_prefixsum

// 구간 합 구하기 5

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val sum = Array(1025) { IntArray(1025) }
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    for (i in 1..N) {
        val r = br.readLine().split(" ").map { it.toInt() }
        for (j in 1..N) {
            sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + r[j - 1]
        }
    }
    repeat(M) {
        val (y1, x1, y2, x2) = br.readLine().split(" ").map { it.toInt() }
        val ret = sum[y2][x2] - sum[y1 - 1][x2] - sum[y2][x1 - 1] + sum[y1 - 1][x1 - 1]
        bw.write("$ret\n")
    }
    bw.close()
}