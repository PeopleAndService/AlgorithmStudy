package boj.week6

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.abs

//  절댓값 힙

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val compare = { a: Int, b: Int ->
        when {
            a > b -> 1
            a < b -> -1
            else -> 0
        }
    }
    val q = PriorityQueue { a: Pair<Int, Int>, b: Pair<Int, Int> ->
        when {
            a.first != b.first -> compare(a.first, b.first)
            else -> compare(a.second, b.second)
        }
    }

    repeat(br.readLine().toInt()) {
        val op = br.readLine().toInt()

        if (op == 0) {
            if (q.isEmpty()) {
                bw.append("0")
            } else {
                bw.append("${q.poll().second}")
            }
            bw.newLine()
        } else {
            q.add(abs(op) to op)
        }
    }

    bw.flush()
    bw.close()
}