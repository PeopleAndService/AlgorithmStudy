package boj.code_plus2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.system.exitProcess

//  일곱 난쟁이

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private val heights = IntArray(9) { br.readLine().toInt() }.sortedArray()

fun main() {
    find(IntArray(7), 0, 0, 1)
}

private fun find(answer: IntArray, sum: Int, start: Int, step: Int) {

    if (step > 7) {
        if (sum == 100) {
            bw.write(answer.joinToString("\n"))
            bw.flush()
            bw.close()
            exitProcess(0)
        }

        return
    }

    for (i in start..heights.lastIndex) {
        answer[step - 1] = heights[i]
        find(answer, sum + heights[i], i + 1, step + 1)
        answer[step - 1] = 0
    }
}