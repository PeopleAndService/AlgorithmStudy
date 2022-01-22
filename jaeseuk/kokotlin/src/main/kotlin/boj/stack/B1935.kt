package boj.stack

import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val exp = readLine()!!
    val mapping = List(n) { readLine()!!.toDouble() }
    val stack = Stack<Double>()

    exp.forEach {
        if (it.isLetter()) {
            stack.push(mapping[it - 'A'])
        } else {
            val second = stack.pop()
            val first = stack.pop()

            when (it) {
                '+' -> stack.push(first + second)
                '-' -> stack.push(first - second)
                '*' -> stack.push(first * second)
                '/' -> stack.push(first / second)
            }
        }
    }

    println(String.format("%.2f", stack.pop()))
}