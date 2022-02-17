package week4

import kotlin.math.*

/*
플랫폼 : 백준
문제번호 : 8911
문제제목 : 거북이
난이도 : 실버 2
제한사항 : 1초/128MB
알고리즘 분류 : 구현, 시뮬레이션

알고리즘 설명
1. x축과 y축의 거북이가 남긴 변의 길이를 알아야함
2. x축에서 갈 수 있는 최대 왼쪽과 최대 오른쪽을 구함, y축에 대해서도 동일
3. 최대 - 최소로 변의 길이를 알 수 있음 -> 넓이 구함

채점 결과 : 356ms/23584KB
풀이 날짜 : 2022/02/16
*/

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    repeat(br.readLine().toInt()) {
        bw.write("${Turtle(br.readLine()).simulation()}\n")
    }
    bw.close()
    br.close()
}

class Turtle(private val orders: String) {
    private var dir = 0
    private var x = 0
    private var y = 0

    private var xLeft = 0
    private var xRight = 0
    private var yUp = 0
    private var yDown = 0

    fun simulation(): Int {
        orders.forEach { ord ->
            when (ord) {
                'F' -> {
                    x += dx[dir]
                    y += dy[dir]
                }
                'B' -> {
                    with(getBackwardDir()) {
                        x += dx[this]
                        y += dy[this]
                    }
                }
                'L' -> {
                    dir = turnLeft()
                }
                'R' -> {
                    dir = turnRight()
                }
            }

            xLeft = min(xLeft, x)
            xRight = max(xRight, x)
            yDown = min(yDown, y)
            yUp = max(yUp, y)
        }

        return (xRight - xLeft) * (yUp - yDown)
    }

    private fun turnLeft() = (dir + 1) % 4

    private fun turnRight() = (dir + 3) % 4

    private fun getBackwardDir() = (dir + 2) % 4

    companion object {
        // 북 -> 서 -> 남 -> 동
        private val dx = intArrayOf(0, -1, 0, 1)
        private val dy = intArrayOf(1, 0, -1, 0)
    }
}