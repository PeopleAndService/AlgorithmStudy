package boj.bronze

// Boiling Water

fun main() = (5* readLine()!!.toInt()-400).run { print("$this\n${if(this==100) 0 else if(this>100) -1 else 1}") }
