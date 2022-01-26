package boj.deque

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    repeat(br.readLine().toInt()) {
        br.readLine()
        val deque = ArrayDeque<String>()

        br.readLine().split(" ").forEach {
            if (deque.isEmpty() || deque.first() < it) deque.addLast(it)
            else deque.addFirst(it)
        }

        bw.append("${deque.joinToString("")}\n")
    }

    bw.flush()
    bw.close()
}