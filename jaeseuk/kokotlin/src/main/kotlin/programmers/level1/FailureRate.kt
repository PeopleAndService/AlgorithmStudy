package programmers.level1

class FailureRate {
    fun solution(N: Int, stages: IntArray): IntArray {
        val players = IntArray(N + 1)
        var answer = arrayOf<Pair<Int, Double>>()
        var left = stages.size.toDouble()

        for (stage in stages) {
            players[stage - 1] += 1
        }

        for (i in 0 until N) {
            if (left != 0.0) {
                answer += i + 1 to players[i] / left
            } else {
                answer += i + 1 to 0.0
            }
            left -= players[i]
        }

        return answer
            .sortedWith(compareBy({-it.second}, {it.first}))
            .map { it.first }
            .toIntArray()
    }
}