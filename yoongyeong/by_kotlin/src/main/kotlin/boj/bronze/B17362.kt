package boj.bronze

// 수학은 체육과목입니다 2

fun main() {
    val num = readLine()!!.toLong()

    if (num < 6) print(num)
    else {
        print(when((num-5)%8){
            0L -> "5"
            1L, 7L -> "4"
            2L, 6L -> "3"
            3L, 5L -> "2"
            else -> "1"
        })
    }
}