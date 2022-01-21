package boj.stack

import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val stack = Stack<Int>()
    var next = 1
    var answer = true

    loop1@ for (ch in readLine()!!.split(' ')) {
        val p = ch.toInt()

        when {
            p == next -> {
                next += 1
            }
            stack.isEmpty() || stack.peek() > p -> {
                stack.push(p)
            }
            else -> {
                while (stack.isNotEmpty() && stack.peek() < p) {
                    if (stack.pop() != next) {
                        answer = false
                        break@loop1
                    }
                    next += 1
                }

                stack.push(p)
            }
        }
    }

    println(if (answer) "Nice" else "Sad")
}