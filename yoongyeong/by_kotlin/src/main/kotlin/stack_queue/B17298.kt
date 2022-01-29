package stack_queue

import java.lang.StringBuilder
import java.util.*

// 오큰수

fun main() {
    val n = readLine()!!.toInt()
    val numbers = readLine()!!.split(" ").map { it.toInt() }
    val result = IntArray(n) { -1 }
    val stack = Stack<Int>()

    repeat(n) {
        while (!stack.empty() && numbers[stack.peek()] < numbers[it]) result[stack.pop()] = numbers[it]
        stack.push(it)
    }

    val sb = StringBuilder()
    for (number in result) sb.append("$number ")

    println(sb.toString())
}