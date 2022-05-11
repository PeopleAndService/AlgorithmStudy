package baekjoon.stack_queue

import java.io.*
import java.util.*
import kotlin.collections.ArrayDeque

// 덱

fun main() {
    val deque = ArrayDeque<Int>()
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    repeat(readLine()!!.toInt()) {
        val st = StringTokenizer(readLine())
        when (st.nextToken()) {
            "push_front" -> deque.addFirst(st.nextToken().toInt())
            "push_back" -> deque.addLast(st.nextToken().toInt())
            "pop_front" -> bw.write(if(deque.isEmpty()) "-1\n" else "${deque.removeFirst()}\n")
            "pop_back" -> bw.write(if(deque.isEmpty()) "-1\n" else "${deque.removeLast()}\n")
            "size" -> bw.write("${deque.size}\n")
            "empty" -> bw.write(if(deque.isEmpty()) "1\n" else "0\n")
            "front" -> bw.write(if(deque.isEmpty()) "-1\n" else "${deque.first()}\n")
            "back" -> bw.write(if(deque.isEmpty()) "-1\n" else "${deque.last()}\n")
        }
    }
    bw.flush(); bw.close()
}