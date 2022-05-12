package programmers.level2

// 큰 수 만들기 (Greedy)

class MakingABigNumber {
    fun solution(number: String, k: Int): String {
        val answer = StringBuilder()
        var idx = 0

        for (i in 0 until number.length - k) {
            var maximum = '0'
            for (j in idx .. i+k) {
                if (maximum < number[j]) {
                    maximum = number[j]
                    idx = j+1
                }
            }
            answer.append(maximum)
        }

        return answer.toString()
    }
}