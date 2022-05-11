package baekjoon.stack_queue

import java.lang.StringBuilder
import java.util.*

// 스택 수열

fun main() {
    val stack = Stack<Int>()
    val st = StringBuilder()
    var index = 1
    repeat(readLine()!!.toInt()) {
        val num = readLine()!!.toInt()
        when {
            stack.empty() || stack.peek() < num -> {
                for (i in index until num) {stack.push(i); st.append("+\n")}
                st.append("+\n-\n")
                index = num + 1
            }
            stack.peek() == num -> {
                stack.pop(); st.append("-\n")
            }
            else -> {
                println("NO"); return
            }
        }
    }
    println(st.toString())
}