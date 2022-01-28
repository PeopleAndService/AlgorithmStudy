package boj.silver

import java.io.BufferedReader
import java.io.InputStreamReader

// 나이순 정렬

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val persons = List(this.readLine().toInt()) {this.readLine().split(" ")}.sortedBy { it[0].toInt() }
    persons.forEach { println("${it[0]} ${it[1]}") }
}