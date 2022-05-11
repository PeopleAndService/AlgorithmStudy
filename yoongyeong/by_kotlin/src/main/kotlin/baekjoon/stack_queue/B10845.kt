package baekjoon.stack_queue

import java.util.*

// 큐

fun main() {
    val queue = LinkedList<Int>()

    repeat(readLine()!!.toInt()) {
        val st = StringTokenizer(readLine())
        when (st.nextToken()) {
            "push" -> queue.add(st.nextToken().toInt())
            "pop" -> println(if(queue.isEmpty()) -1 else queue.poll())
            "size" -> println(queue.size)
            "empty" -> println(if(queue.isEmpty()) 1 else 0)
            "front" -> println(if(queue.isEmpty()) -1 else queue.first)
            "back" -> println(if(queue.isEmpty()) -1 else queue.last)
        }
    }
}