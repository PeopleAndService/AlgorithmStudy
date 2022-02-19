package week5

import java.util.StringTokenizer

/*
플랫폼 : 백준
문제번호 : 9184
문제제목 : 신나는 함수 실행
난이도 : 실버 2
제한사항 : 1초/128MB
알고리즘 분류 : DP

알고리즘 설명
1. 시작 조건이 주어졌고
2. 나머지 경우에 대해 메모이제이션 하면서 w 함수 수행

채점 결과 : 276ms/24172KB
풀이 날짜 : 2022/02/19
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    B9184().start()
    bw.close()
    br.close()
}

class B9184 {
    private val dp = Array(SIZE+1) { Array(SIZE+1) { IntArray(SIZE+1) } }

    fun start() {
        while (true) {
            with(StringTokenizer(br.readLine())) {
                val a = nextToken().toInt()
                val b = nextToken().toInt()
                val c = nextToken().toInt()

                if (a == -1 && b == -1 && c == -1) {
                    return
                }

                bw.write("w($a, $b, $c) = ${w(a, b, c)}")
                bw.newLine()
            }
        }
    }

    private fun w(a: Int, b: Int, c: Int): Int {
        if (checkNegative(a, b, c)) return 1
        if (checkOverSize(a, b, c)) return w(SIZE, SIZE, SIZE)

        if (dp[a][b][c] != 0) return dp[a][b][c]

        dp[a][b][c] =
            if (b in (a + 1) until c) w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
            else w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)

        return dp[a][b][c]
    }

    private fun checkNegative(a: Int, b: Int, c: Int) = a <= 0 || b <= 0 || c <= 0

    private fun checkOverSize(a: Int, b: Int, c: Int) = a > SIZE || b > SIZE || c > SIZE

    companion object {
        private const val SIZE = 20
    }
}