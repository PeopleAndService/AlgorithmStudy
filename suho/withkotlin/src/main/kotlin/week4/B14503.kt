package week4

import java.util.StringTokenizer

/*
플랫폼 : 백준
문제번호 : 14503
문제제목 : 로봇 청소기
난이도 : 골드 5
제한사항 : 2초/512MB
알고리즘 분류 : 구현, 시뮬레이션

알고리즘 설명
문제에 주석으로 해놓음

채점 결과 : 100ms/12784KB
풀이 날짜 : 2022/02/14
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val (n, m) = with(StringTokenizer(br.readLine())) { nextToken().toInt() to nextToken().toInt() }
    with(StringTokenizer(br.readLine())) {
        bw.write("${RobotCleaner(n, m, nextToken().toInt(), nextToken().toInt(), nextToken().toInt()).start()}")
    }

    br.close()
    bw.close()
}

class RobotCleaner(
    private val n: Int,
    private val m: Int,
    private var r: Int,
    private var c: Int,
    private var d: Int,
) {
    // 빈 칸: 0, 벽: 1 이고 청소한 칸: -1로 하자
    private val map = Array(n) { with(StringTokenizer(br.readLine())) { IntArray(m) { nextToken().toInt() } } }

    private var count = 0

    fun start(): Int {
        /*
        1. 현재 위치 청소
        2. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 인접한 칸을 탐색
            a. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면(0), 그 방향으로 회전한 다음 한 칸을 전진하고 1.로
            b. 왼쪽 방향에 청소할 공간이 없다면(!= 0), 그 방향으로 회전하고 2.로
            c. 4방향 모두 봤어 -> 바라보는 방향 유지한 채로 한 칸 후진 후 2.로
            d. c에서 후진을 못함(뒤 좌표 영역 == 1) -> 그만

        ! 외벽이 다 1로 되어있어서 영역 내인지 확인하지 않아도 된다.
        ! 이미 청소되어있는 칸은 세지 않음
        */
        map[r][c] = -1
        count++

        while (true) {
            // 왼쪽 방향
            var isMove = false

            for (i in 0 until 4) {
                val nextDir = calcDir()

                val nr = r + dr[nextDir]
                val nc = c + dc[nextDir]

                if (map[nr][nc] == 0) {
                    d = nextDir
                    r = nr
                    c = nc
                    isMove = true
                    break
                }

                d = nextDir
            }

            if (isMove) {
                clean()
            } else {
                if (!backwardCheck()) {
                    break
                } else {
                    with(backwardDir()) {
                        r += dr[this]
                        c += dc[this]
                    }
                }
            }
        }

        return count
    }

    private fun calcDir() = if (d - 1 < 0) 3 else d - 1

    private fun backwardDir() = (d + 2) % 4

    private fun backwardCheck() = with(backwardDir()) { map[r+dr[this]][c+dc[this]] != 1 }

    private fun clean() {
        map[r][c] = -1
        count++
    }

    companion object {
        // 북 - 동 - 남 - 서
        private val dr = intArrayOf(-1, 0, 1, 0)
        private val dc = intArrayOf(0, 1, 0, -1)
    }
}