package boj.bronze

// 과목 선택

fun main() {
    val science = IntArray(4) { readLine()!!.toInt()}
    val social = IntArray(2) { readLine()!!.toInt()}
    println(science.sum()+social.sum()- science.minOrNull()!!-social.minOrNull()!!)
}