package simulation_greedy

import java.util.*

// A -> B

private var a = 0L; private var b = 0L
private var minimum = Long.MAX_VALUE

fun main() {
    StringTokenizer(System.`in`.bufferedReader().readLine()).run {
        a = nextToken().toLong(); b = nextToken().toLong()
    }
    changeNumber()
    print(if (minimum == Long.MAX_VALUE) -1 else minimum + 1)
}

private fun changeNumber(number: Long = a, cnt: Long = 0L) {
    if (number == b) {
        minimum = minOf(minimum, cnt); return
    }
    if (number * 2 <= b) changeNumber(number * 2, cnt + 1)
    if (number * 10 + 1 <= b) changeNumber(number * 10 + 1, cnt + 1)
}