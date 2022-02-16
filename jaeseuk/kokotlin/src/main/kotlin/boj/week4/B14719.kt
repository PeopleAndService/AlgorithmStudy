package boj.week4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (h, w) = br.readLine().split(" ").map { it.toInt() }
    val blocks = StringTokenizer(br.readLine()).run { Array(w) { nextToken().toInt() } }

    val stack = Stack<Int>()
    var answer = 0

    blocks.forEach { block ->
        if (stack.isEmpty()) {
            stack.push(block)
        } else {
            if (stack[0] <= block) {
                while (stack.size > 1) {
                    answer += stack[0] - stack.pop()
                }

                stack.pop()
            }

            stack.push(block)
        }
    }

    if (stack.size >= 3) {
        var maxH = minOf(stack[0], stack.pop())

        while (stack.size > 1) {
            val block = stack.pop()
            maxH = maxOf(maxH, block)
            answer += maxH - block
        }
    }

    bw.append("$answer")
    bw.flush()
    bw.close()
}