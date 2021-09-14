package programmers.level1

class FactorsNumberAdd {
    fun solution(left: Int, right: Int): Int {
        var answer: Int = 0

        for (i in left..right) {
            if (Math.sqrt(i.toDouble()) % 1 > 0) {
                answer += i
            } else {
                answer -= i
            }
        }

        return answer
    }
}