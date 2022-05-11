package baekjoon.backTracking_recursion

import java.io.*

// 연산자 끼워넣기

private var n = 0
private lateinit var numbers: List<Int>
private var minimum = Int.MAX_VALUE; private var maximum = Int.MIN_VALUE

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    numbers = br.readLine().split(" ").map { it.toInt() }
    val (a, b, c, d) = br.readLine().split(" ").map { it.toInt() }

    calculator(numbers[0], 1, a, b, c, d)

    print("$maximum\n$minimum")

}

private fun calculator(num: Int, idx: Int, plus: Int, minus: Int, multi: Int, division: Int) {
    if (idx == n) {
        maximum = maxOf(num, maximum)
        minimum = minOf(num, minimum)
        return
    }
    if (plus != 0) calculator(num + numbers[idx], idx + 1, plus - 1, minus, multi, division)
    if (minus != 0) calculator(num - numbers[idx], idx + 1, plus, minus - 1, multi, division)
    if (multi != 0) calculator(num * numbers[idx], idx + 1, plus, minus, multi - 1, division)
    if (division != 0) calculator(num / numbers[idx], idx + 1, plus, minus, multi, division - 1)
}