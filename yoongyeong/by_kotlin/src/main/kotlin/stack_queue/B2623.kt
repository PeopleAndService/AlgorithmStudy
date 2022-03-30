package stack_queue

import java.util.LinkedList
import java.util.StringTokenizer

// 음악프로그램

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()

    val n: Int; val m: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt(); m = nextToken().toInt()
    }
    val array = Array(n+1) {IntArray(n+1)}
    val inDegree = IntArray(n+1)

    repeat(m) {
        with(StringTokenizer(br.readLine())) {
            val singer = nextToken().toInt()
            var start = nextToken().toInt()

            for (i in 0 until singer - 1) {
                val end = nextToken().toInt()

                if (array[start][end] == 0) {
                    array[start][end] = 1
                    inDegree[end]++
                }

                start = end
            }
        }
    }

    val queue = LinkedList<Int>()
    for (i in 1 .. n) {
        if (inDegree[i] == 0) queue.add(i)
    }

    while (!queue.isEmpty()) {
        val node = queue.poll()
        sb.append("$node\n")

        for (i in 1 .. n) {
            if (array[node][i] == 1) {
                inDegree[i]--
                if (inDegree[i] == 0) queue.add(i)
            }
        }
    }

    print(if (inDegree.count{it != 0} > 0) 0 else sb.toString())
}