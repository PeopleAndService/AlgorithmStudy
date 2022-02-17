package boj.week4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()

    val use = PriorityQueue<Int>()
    val classes = Array(n) { br.readLine().split(" ").run { first().toInt() to last().toInt() } }
        .sortedArrayWith(compareBy({ it.first }, { it.second }))

    var answer = 1
    use.offer(classes[0].second)

    for (i in 1 until n) {
        val cls = classes[i]

        if (use.peek() <= cls.first) use.poll()
        else answer++

        use.offer(cls.second)
    }

    bw.append("$answer")
    bw.flush()
    bw.close()
}