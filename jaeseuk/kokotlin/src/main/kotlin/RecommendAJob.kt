class RecommendAJob {
    fun solution(table: Array<String>, languages: Array<String>, preference: IntArray): String {
        var answer = Pair<Int, String>(0, "")

        table.map { it.split(" ") }.forEach {
            var score = 0
            for (lan in languages zip preference.toTypedArray()) {
                if (lan.first in it) {
                    score += (6 - it.indexOf(lan.first)) * lan.second
                }
            }

            answer = if (answer.first > score) {
                answer
            } else if (answer.first == score) {
                if (answer.second > it[0]) Pair(score, it[0]) else answer
            } else {
                Pair(score, it[0])
            }
        }
        return answer.second
    }
}