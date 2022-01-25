package boj.stack

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val left = LinkedList<String>()
    val right = LinkedList<String>()

    br.readLine().forEach {
        left.offer(it + "")
    }

    repeat(br.readLine().toInt()) {
        val opr = br.readLine().split(" ")

        when {
            opr[0] == "L" && left.isNotEmpty() -> right.offerFirst(left.pollLast())
            opr[0] == "D" && right.isNotEmpty() -> left.offerLast(right.pollFirst())
            opr[0] == "B" && left.isNotEmpty() -> left.pollLast()
            opr[0] == "P" -> left.offerLast(opr[1])
        }
    }

    while (left.isNotEmpty()) bw.append(left.pollFirst())
    while (right.isNotEmpty()) bw.append(right.pollFirst())

    bw.flush()
    bw.close()
}