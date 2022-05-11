package baekjoon.stack_queue

import java.util.*

// 스택

fun main() {
    val stack = Stack<Int>()

    repeat(readLine()!!.toInt()) {
        val st = StringTokenizer(readLine())
        when (st.nextToken()) {
            "push" -> stack.push(st.nextToken().toInt())
            "pop" -> println(if(stack.empty()) -1 else stack.pop())
            "top" -> println(if(stack.empty()) -1 else stack.peek())
            "size" -> println(stack.size)
            "empty" -> println(if(stack.empty()) 1 else 0)
        }
    }
}