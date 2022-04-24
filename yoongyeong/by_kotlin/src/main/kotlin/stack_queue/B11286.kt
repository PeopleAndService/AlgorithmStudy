package stack_queue

import java.util.PriorityQueue

// 절댓값 힙

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val plus = PriorityQueue<Int>()
    val minus = PriorityQueue<Int>()

    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val x = br.readLine().toInt()
        if (x == 0) {
            val p = plus.peek()  ?: 0
            val m = minus.peek() ?: 0
            bw.write("${when {
                p == 0 && m == 0 -> 0
                p == 0 -> -minus.poll()
                m == 0 -> plus.poll()
                p < m -> plus.poll()
                else -> -minus.poll()
            }}\n")
        } else {
            if (x > 0) {
                plus.add(x)
            } else {
                minus.add(-x)
            }
        }

    }

    bw.close()
    br.close()
}