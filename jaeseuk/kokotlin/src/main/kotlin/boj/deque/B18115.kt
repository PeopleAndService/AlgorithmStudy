package boj.deque

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val skills = br.readLine().split(" ")
    val deque = ArrayDeque<Int>()

    for (i in 1..n) {
        when (skills[n - i]) {
            "1" -> deque.addFirst(i)
            "2" -> {
                if (deque.size == 1) {
                    deque.addLast(i)
                } else {
                    val tmp = deque.removeFirst()
                    deque.addFirst(i)
                    deque.addFirst((tmp))
                }
            }
            "3" -> deque.addLast(i)
        }
    }

    bw.write(deque.joinToString(" "))
    bw.flush()
    bw.close()
}