package boj.bronze

import kotlin.math.abs

// 팀 나누기

fun main() {
    val team = readLine()!!.split(" ").map { it.toLong() }.sorted()
    println(abs(team[0]+team[3]-team[1]-team[2]))
}