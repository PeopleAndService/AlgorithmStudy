package baekjoon.stack_queue

import kotlin.collections.ArrayDeque

// 회전하는 큐

fun main() {
    val (n, _) = readLine()!!.split(" ").map { it.toInt() }
    val numbers = readLine()!!.split(" ").map {it.toInt()}
    val queue = ArrayDeque(List(n) { x -> x+1 }) ; var answer = 0

    for (number in numbers) {
        if (queue.first() == number) queue.removeFirst()
        else {
            val idx = queue.indexOf(number)
            if (idx > queue.size / 2) {
                (queue.size - idx).run {
                    queue.rotate(this); answer += this
                }
            } else {
                queue.rotate(-idx); answer += idx
            }
            queue.removeFirst()
        }
    }

    println(answer)
}

fun ArrayDeque<Int>.rotate(num: Int) {
    if (num > 0) {
        repeat(num) {
            this.addFirst(this.removeLast())
        }
    } else {
        repeat(-num) {
            this.addLast(this.removeFirst())
        }
    }
}