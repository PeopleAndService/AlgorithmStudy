package boj.bronze

// 벌집

fun main() {
    val n = readLine()!!.toInt()
    if (n == 1) println(1)
    else {
        var answer = 1
        var roomNum = 1
        while (roomNum < n) {
            roomNum += answer * 6
            answer += 1
        }
        println(answer)
    }
}