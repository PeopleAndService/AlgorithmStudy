package boj.bronze

// Tournament Selection

fun main() {
    val cnt = List(6) { readLine()!!}.count{it == "W"}
    print(when{
        cnt >= 5 -> 1
        cnt >= 3 -> 2
        cnt >= 1 -> 3
        else -> -1
    })
}