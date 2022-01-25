package boj.bronze

// Even or Odd?

fun main() = print(when(readLine()!!.toInt()%4) {2 -> "1"; 0->"2"; else-> "0"})