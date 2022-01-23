package boj.bronze

// CASIO

fun main() = print(if(readLine()!!.split(" ").let { it[0]==it[1] })1 else 0)