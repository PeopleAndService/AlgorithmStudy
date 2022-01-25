package boj.queue

import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val parrots = Array<LinkedList<String>>(n) {
        LinkedList(readLine()!!.split(" "))
    }
    val l = readLine()!!.split(" ")

    l.forEach {
        for (i in 0..parrots.lastIndex) {
            if (parrots[i].isNotEmpty() && parrots[i].first == it) {
                parrots[i].pollFirst()
                break
            } else if (i == parrots.lastIndex) {
                println("Impossible")
                return
            }
        }
    }

    println(if (parrots.count { it.size == 0 } == n) "Possible" else "Impossible")
}