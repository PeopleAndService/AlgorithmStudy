package boj.backtracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private var k = 0
private lateinit var s: Array<String>

fun main() {
    while (true) {
        br.readLine().split(" ").run {
            k = first().toInt()
            s = drop(1).toTypedArray()
        }

        if (k == 0) break

        val com = LinkedList<String>()

        repeat(k - 5) {
            com.add(s[it])
            combination(com, it + 1)
            com.remove(s[it])
        }

        bw.append("\n")
    }

    bw.flush()
    bw.close()
}

private fun combination(com: LinkedList<String>, start: Int) {
    if (com.size == 6) {
        bw.append(com.joinToString(separator = " ", postfix = "\n"))
        return
    }

    for (i in start until k) {
        com.add(s[i])
        combination(com, i + 1)
        com.remove(s[i])
    }
}