package boj.bronze

// 운동장 한 바퀴

fun main() {
    val (d1, d2) = List(2) { readLine()!!.toInt()}
    print(d2*2*3.141592+2*d1)
}