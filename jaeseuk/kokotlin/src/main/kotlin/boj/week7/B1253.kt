package boj.week7

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

//  좋다

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val numbers = StringTokenizer(br.readLine()).run { IntArray(n) { nextToken().toInt() }.sortedArray() }

    var answer = 0

    for (i in numbers.indices) {
        var start = 0
        var end = n - 1

        while (start < end) {
            when (i) {
                start -> start++
                end -> end--
                else -> {
                    val sum = numbers[start] + numbers[end]

                    when {
                        sum == numbers[i] -> {
                            answer++
                            break
                        }
                        sum < numbers[i] -> start++
                        sum > numbers[i] -> end--
                    }
                }
            }
        }
    }

    bw.append("$answer")
    bw.flush()
    bw.close()
}