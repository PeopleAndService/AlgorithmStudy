package stack_queue

import java.util.*

// 프린터 큐

fun main() {
    repeat(readLine()!!.toInt()) {
        val (_, m) = readLine()!!.split(" ").map { it.toInt() }
        val docs = readLine()!!.split(" ").map { it.toInt() }
        val queue = LinkedList<IndexedValue<Int>>()
        var answer = 0

        for (pair in docs.withIndex()) queue.offer(pair)

        while (queue.isNotEmpty()) {
            val cursor = queue.poll()

            if (queue.isNotEmpty() && queue.maxOf { it.value } > cursor.value) queue.offer(cursor)
            else {answer++; if (cursor.index == m) break}
        }

        println(answer)
    }
}