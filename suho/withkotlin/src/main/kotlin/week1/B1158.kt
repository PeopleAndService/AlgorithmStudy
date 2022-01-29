package week1

import java.util.*

/*
채점 결과 : 628ms/299512KB
풀이 날짜 : 2022/01/21
*/

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val queue = LinkedList<Int>()
    repeat(n) {
        queue.offer(it + 1)
    }

    System.out.bufferedWriter().use { bw ->
        bw.write("<")
        while (queue.size != 1) {
            bw.write("${queue.printOrder(k)}, ")
        }
        bw.write("${queue.poll()}>")
        bw.flush()
    }
}

private fun <T : Number> Queue<T>.printOrder(k: Int): T {
    repeat(k - 1) {
        this.offer(this.poll())
    }

    return this.poll()
}