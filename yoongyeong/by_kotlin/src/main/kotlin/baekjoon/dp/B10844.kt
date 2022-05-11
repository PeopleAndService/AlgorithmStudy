package baekjoon.dp

// 쉬운 계단 수

fun main() {
    val n = System.`in`.bufferedReader().readLine().toInt()
    val stair = Array(n) {LongArray(10) {1L} }; stair[0][0] = 0L
    for (i in 1 until n) {
        for (j in 0 until 10) {
            stair[i][j] = when(j) {
                0 -> stair[i-1][1]
                9 -> stair[i-1][8]
                else -> (stair[i-1][j-1] + stair[i-1][j+1])
            } % 1_000_000_000
        }
    }
    print(stair[n-1].sum() % 1_000_000_000)
}