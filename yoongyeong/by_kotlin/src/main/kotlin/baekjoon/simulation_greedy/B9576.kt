package baekjoon.simulation_greedy

import java.util.*

// 책 나눠주기

fun main() {
    val br = System.`in`.bufferedReader()
    repeat(br.readLine().toInt()) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val books = mutableListOf<Pair<Int, Int>>()
        val checks = BooleanArray(n+1); var result = 0
        repeat(m) {
            StringTokenizer(br.readLine()).run {
                books.add(Pair(nextToken().toInt(), nextToken().toInt()))
            }
        }
        books.sortWith(compareBy({it.second}, {it.first}))

        for (book in books) {
            for (number in book.first .. book.second) {
                if (!checks[number]) {
                    result++; checks[number] = true; break
                }
            }
        }

        println(result)
    }
}