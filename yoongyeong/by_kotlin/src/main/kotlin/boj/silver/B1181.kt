package boj.silver

import java.io.BufferedReader
import java.io.InputStreamReader

// 단어 정렬

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    println(List(this.readLine().toInt()) {this.readLine()}.toSet().sortedWith(compareBy({it.length}, {it})).joinToString("\n"))
}