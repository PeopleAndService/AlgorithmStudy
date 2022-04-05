package boj.week11

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

//  패션왕 신해빈

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    repeat(br.readLine().toInt()) {
        val n = br.readLine().toInt()
        val clothes = mutableMapOf<String, Int>()

        for (i in 0 until n) {
            val clothesType = br.readLine().split(" ").last()
            clothes[clothesType] = clothes.getOrDefault(clothesType, 0) + 1
        }

        val clothesTypes = clothes.keys.toTypedArray()
        var answer = 0

        for (i in clothesTypes.indices) {
            val clothesType = clothesTypes[i]
            val clothesCnt = clothes[clothesType]!!

            if (i == 0) {
                answer = clothesCnt
            } else {
                answer += answer * clothesCnt + clothesCnt
            }
        }

        bw.write("$answer")
        bw.newLine()
    }

    bw.flush()
    bw.close()
}