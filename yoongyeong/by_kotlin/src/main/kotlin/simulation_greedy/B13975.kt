package simulation_greedy

import java.util.*

// 파일 합치기 3

fun main() {
    val br = System.`in`.bufferedReader()
    repeat(br.readLine().toInt()) {
        val n = br.readLine().toInt()
        val queue = PriorityQueue<Long>()
        var result = 0L

        StringTokenizer(br.readLine()).run {
            for (i in 0 until n) queue.add(nextToken().toLong())
        }

        while (queue.size > 1) {
            (queue.poll() + queue.poll()).run {
                result += this; queue.add(this)
            }
        }

        println(result)
    }
}
