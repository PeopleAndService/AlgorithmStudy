package boj.bronze

// 短針 (Hour Hand)

fun main() = print((readLine()!!.toInt()+ readLine()!!.toInt()-1)%12+1)