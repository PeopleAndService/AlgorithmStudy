package boj.bronze

fun main() = print(readLine()!!.split(" ").let { if(it[0].toInt()>=8) "satisfactory" else "unsatisfactory" })