package boj.bronze

// 그대로 출력하기

fun main() {
    var str = readLine()
    while (!str.isNullOrBlank()) {
        println(str)
        str = readLine()
    }
}