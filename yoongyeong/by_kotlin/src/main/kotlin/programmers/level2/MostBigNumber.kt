package programmers.level2

class MostBigNumber {
    fun solution(numbers: IntArray): String {
        val answer = numbers.sortedByDescending { it.toString().repeat(3).take(3) }
        return if (answer[0] == 0) "0" else answer.joinToString("")
    }
}