package boj.stack

import java.util.*

fun main() {
    var answer = 0

    repeat(readLine()!!.toInt()) {
        val stack = Stack<Char>()

        for (ch in readLine()!!) {
            if (stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch)
            } else {
                stack.pop()
            }
        }

        if (stack.isEmpty()) answer += 1
    }

    println(answer)
}