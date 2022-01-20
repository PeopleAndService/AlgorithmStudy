package boj.stack

import java.util.*

fun main() {
    val batch = readLine()!!
    val stack = Stack<Int>()
    var answer = 0

    batch.forEachIndexed { index, c ->
        if (c == '(') {
            stack.push(index)
        } else {
            answer += if (stack.isEmpty() || index - stack.pop() == 1) {
                stack.size
            } else {
                1
            }
        }
    }

    println(answer)
}