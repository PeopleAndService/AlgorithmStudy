package boj.bronze

// 킹, 퀸, 룩, 비숍, 나이트, 폰

fun main() {
    val list = readLine()!!.split(" ").map { it.toInt() }
    println("${1-list[0]} ${1-list[1]} ${2-list[2]} ${2-list[3]} ${2-list[4]} ${8-list[5]} ")
}