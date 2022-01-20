package boj.queue

import java.util.*

fun main() {
    val queue = LinkedList<Int>()
    repeat(readLine()!!.toInt()) { queue.offer(it + 1) }

    while (queue.size > 1) {
        print("${queue.pollFirst()} ")
        queue.offer(queue.pollFirst())
    }

    print(queue.poll())
}