package boj.week11

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

//  수강신청

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (k, l) = br.readLine().split(" ").map { it.toInt() }
    val students = mutableMapOf<String, Int>()

    repeat(l) {
        students[br.readLine()] = it
    }

    students.entries.sortedBy { it.value }.take(k).forEach {
        bw.write(it.key)
        bw.newLine()
    }

    bw.flush()
    bw.close()
}