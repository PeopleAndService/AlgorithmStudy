package baekjoon.stack_queue

import java.util.*

// 제로

fun main() {
    val stack = Stack<Int>()

    repeat(readLine()!!.toInt()) {
        val number = readLine()!!.toInt()
        if (number == 0) stack.pop() else stack.push(number)
    }

    println(stack.sum())
}