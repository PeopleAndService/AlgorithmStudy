package baekjoon.dp

// 신나는 함수 실행

fun main() {
    val br = System.`in`.bufferedReader(); val bw = System.out.bufferedWriter()
    val dp = Array(21) {Array(21) {IntArray(21) {1} } }
    for (a in 1 .. 20) {
        for (b in 1 ..  20) {
            for (c in 1 .. 20) {
                if (b in (a + 1) until c) dp[a][b][c] = dp[a][b][c-1] + dp[a][b-1][c-1] - dp[a][b-1][c-1]
                else dp[a][b][c] = dp[a-1][b][c] + dp[a-1][b-1][c] + dp[a-1][b][c-1] - dp[a-1][b-1][c-1]
            }
        }
    }
    var line = br.readLine()

    while (line != "-1 -1 -1") {
        val (a, b, c) = line.split(" ").map { it.toInt() }
        if (a <= 0 || b<=0 || c<=0 ) bw.write("w($a, $b, $c) = 1\n")
        else if (a > 20 || b > 20 || c>20) bw.write("w($a, $b, $c) = ${dp[20][20][20]}\n")
        else bw.write("w($a, $b, $c) = ${dp[a][b][c]}\n")
        line = br.readLine()
    }

    bw.close()
}