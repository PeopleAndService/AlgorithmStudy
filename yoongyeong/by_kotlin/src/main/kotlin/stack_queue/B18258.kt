package stack_queue

import java.util.*

// 큐 2

fun main() {
    val queue: Queue<Int> = LinkedList()
    System.`out`.bufferedWriter().use { bw ->
        fun printInt(x: Int) {
            bw.write(x.toString())
            bw.newLine()
        }

        repeat(readLine()!!.toInt()) {
            val st = StringTokenizer(readLine())
            when (st.nextToken()) {
                "push" -> queue.offer(st.nextToken().toInt())
                "pop" -> printInt(if (queue.isEmpty()) -1 else queue.poll())
                "size" -> printInt(queue.size)
                "empty" -> printInt(if (queue.isEmpty()) 1 else 0)
                "front" -> printInt(if (queue.isEmpty()) -1 else queue.peek())
                "back" -> printInt(if (queue.isEmpty()) -1 else queue.last())
            }
        }
    }
}