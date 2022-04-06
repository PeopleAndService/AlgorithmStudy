package boj.week11

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

//  베스트셀러

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val books = mutableMapOf<String, Int>()

    repeat(n) {
        val book = br.readLine()
        books[book] = books.getOrDefault(book, 0) + 1
    }

    bw.write(books.entries.sortedWith(compareBy({ -it.value }, { it.key })).first().key)
    bw.flush()
    bw.close()
}