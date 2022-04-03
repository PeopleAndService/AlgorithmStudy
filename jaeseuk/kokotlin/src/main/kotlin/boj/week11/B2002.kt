package boj.week11

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

//  추월

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val enter = mutableMapOf<String, Int>()

    repeat(n) {
        enter[br.readLine()] = it
    }

    val exit = Array(n) { br.readLine() }
    var answer = 0

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (enter[exit[i]]!! > enter[exit[j]]!!) {
                answer++
                break
            }
        }
    }

    bw.write("$answer")
    bw.flush()
    bw.close()
}