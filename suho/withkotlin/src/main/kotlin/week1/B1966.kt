package week1

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

/*
채점 결과 : 192ms/22248KB
풀이 날짜 : 2022/01/22
*/

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    repeat(readln().toInt()) {
        val (_, m) = readln().split(" ").map { it.toInt() }
        val printQueue = LinkedList<Document>()
        readln().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
            printQueue.offer(Document(index, i))
        }

        bw.write("${print(printQueue, m)}\n")
    }
    bw.flush()
    bw.close()
}

data class Document(val idx: Int, val priority: Int)

fun print(queue: LinkedList<Document>, m: Int): Int {
    var order = 0

    while (!queue.isEmpty()) {
        val cur = queue.poll()

        if (check(queue, cur)) order++ else continue
        if (cur.idx == m) break
    }

    return order
}

fun check(queue: LinkedList<Document>, cur: Document): Boolean {
    for (i in queue.indices) {
        if (cur.priority < queue[i].priority) {
            queue.offer(cur)
            repeat(i) {
                queue.offer(queue.poll())
            }
            return false
        }
    }
    return true
}
