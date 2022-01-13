package boj.bronze

// 다이얼

fun main() {
    val call = readLine()!!
    var answer = 0
    for (c in call) {
        answer += when (c) {
            'A', 'B', 'C' -> 3
            'D', 'E', 'F' -> 4
            'G', 'H', 'I' -> 5
            'J', 'K', 'L' -> 6
            'M', 'N', 'O' -> 7
            'P', 'Q', 'R', 'S' -> 8
            'T', 'U', 'V' -> 9
            'W', 'X', 'Y', 'Z' -> 10
            else -> 11
        }
    }
    println(answer)
}