package boj.bronze

// 평균 점수

fun main() = println(List(5) { readLine()!!.toInt().let { if(it < 40) 40 else it }}.average().toInt())
