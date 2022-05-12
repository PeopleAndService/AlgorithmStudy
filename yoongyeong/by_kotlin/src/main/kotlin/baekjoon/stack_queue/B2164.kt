package baekjoon.stack_queue

import java.util.*

// 카드2

fun main() {
    val n = readLine()!!.toInt(); var r = 1
    while(r<n) r*=2
    print(2*n-r)
}

fun main2() {
    val queue: Queue<Int> = LinkedList()
    repeat(readLine()!!.toInt()) {queue.offer(it + 1)}
    while (queue.size != 1) {queue.poll(); queue.offer(queue.poll())}
    println(queue.poll())
}