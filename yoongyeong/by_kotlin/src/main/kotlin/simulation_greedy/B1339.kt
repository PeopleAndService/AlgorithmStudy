package simulation_greedy

import kotlin.math.pow

// 단어 수학

fun main() {
    val br = System.`in`.bufferedReader()
    val alphabet = IntArray(26) ; var result = 0

    repeat(br.readLine().toInt()) {
        val word = br.readLine()
        word.forEachIndexed { index, c -> alphabet[c - 'A'] += 1 * 10.0.pow(word.length -index - 1).toInt() }
    }
    alphabet.sortDescending()

    for (number in 0 until 9) result += alphabet[number] * (9-number)
    print(result)
}