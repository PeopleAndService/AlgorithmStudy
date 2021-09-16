package programmers.level1

class KthNumber {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        val answer = IntArray(commands.size) {
            array.slice(commands[it][0] - 1..commands[it][1] - 1)
                .sorted()[commands[it][2] - 1]
        }
        return answer
    }
}