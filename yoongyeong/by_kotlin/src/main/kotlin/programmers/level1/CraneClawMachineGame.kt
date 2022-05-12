package programmers.level1

import java.util.*

// 크레인 인형뽑기 게임 (2019 카카오 개발자 겨울 인턴십)

class CraneClawMachineGame {
    fun solution(oldBoard: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val boardSize = oldBoard.size
        val boards = Array(boardSize) { LinkedList<Int>() }
        for (r in 0 until boardSize) {
            for (c in 0 until boardSize) {
                val dollNum = oldBoard[r][c]
                if (dollNum != 0) {
                    boards[c].add(dollNum)
                }
            }
        }

        val basket = LinkedList<Int>()

        for (move in moves) {
            if (boards[move-1].isNotEmpty()) {
                val dollNum = boards[move-1].pollFirst()
                if (basket.isNotEmpty() && basket.last == dollNum) {
                    answer += 2
                    basket.pollLast()
                } else {
                    basket.add(dollNum)
                }
            }
        }

        return answer
    }
}