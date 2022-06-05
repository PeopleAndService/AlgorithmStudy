package baekjoon.bruteforce

// 체스판 다시 칠하기

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val chessBoard = Array<String>(n) { br.readLine() }
    var minimum = Int.MAX_VALUE

    for (r in 0 .. n - 8) {
        for (c in 0 .. m - 8) {
            var whiteChess = 0 // WBWBWBWB
            var blackChess = 0 // BWBWBWBW

            for (rIdx in r until r+8) {
                for (cIdx in c until c+8) {
                    if ((rIdx + cIdx) % 2 == 0) {
                        if (chessBoard[rIdx][cIdx] == 'W') blackChess++
                        else whiteChess++
                    } else {
                        if (chessBoard[rIdx][cIdx] == 'W') whiteChess++
                        else blackChess++
                    }
                }
            }

            minimum = minOf(minimum, minOf(whiteChess, blackChess))
        }
    }

    println(minimum)
}