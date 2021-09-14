package programmers.level1

class Flip3Digit {
    /**
     * 더 간단한 코드
     * fun solution(n: Int): Int {
     *     return n.toString(3).reversed().toInt(3)
     * }
     */

    fun solution(n: Int): Int {
        var answer: Int = n
        var tmp = ""

        while (answer > 0) {
            tmp += (answer % 3).toString()
            answer /= 3
        }

        return tmp.toInt(3)
    }
}