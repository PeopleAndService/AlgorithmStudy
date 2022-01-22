package boj.queue

import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val queue = LinkedList<Int>()

    while (true) {
        val packet = readLine()!!.toInt()

        if (packet == -1) break

        if (packet == 0) {
            queue.pollFirst()
        } else if (queue.size < n) {
            queue.offer(packet)
        }
    }

    println(if (queue.isEmpty()) "empty" else queue.joinToString(" "))
}