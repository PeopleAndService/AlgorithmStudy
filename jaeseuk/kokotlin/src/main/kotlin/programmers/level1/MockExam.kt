package programmers.level1

class MockExam {
    fun solution(answers: IntArray): IntArray {
        val first = intArrayOf(1, 2, 3, 4, 5)
        val firstSize = first.size
        val second = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val secondSize = second.size
        val third = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        val thirdSize = third.size

        val people = intArrayOf(0, 0, 0)

        for (i in 0..answers.lastIndex) {
            if (first[i % firstSize] ==  answers[i]) {
                people[0] += 1
            }

            if (second[i % secondSize] ==  answers[i]) {
                people[1] += 1
            }

            if (third[i % thirdSize] ==  answers[i]) {
                people[2] += 1
            }
        }

        val maxScore = people.maxOrNull() // 프로그래머스에 maxOrNull 없음.. max() is deprecated
        var answer = intArrayOf()

        people.forEachIndexed { i, e -> if (e == maxScore) answer += i + 1 }

        return answer
    }
}