package stack_queue

import java.util.*

// 균형잡힌 세상

fun main() {
    while (true) {
        val command = readLine()!!
        if (command == ".") break
        val stack = Stack<Char>()

        for (c in command) {
            when (c) {
                '(', '[' -> stack.push(c)
                ')' -> {
                    if (stack.empty() || stack.peek() != '(') {stack.push(c); break}
                    else stack.pop()
                }
                ']' -> {
                    if (stack.empty() || stack.peek() != '[') {stack.push(c); break}
                    else stack.pop()
                }
            }
        }
        println(if (stack.isEmpty()) "yes" else "no")
    }
}