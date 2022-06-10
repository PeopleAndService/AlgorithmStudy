package baekjoon.backTracking_recursion

import java.util.StringTokenizer
import kotlin.math.pow

// Z

private var r = 0
private var c = 0

fun main() {
    val br = System.`in`.bufferedReader()
    val n: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        r = nextToken().toInt()
        c = nextToken().toInt()
    }
    print(getZRecursion((2.0).pow(n).toInt()))
}

private fun getZRecursion(n: Int): Int {
    val half = n / 2
    val piece = if ((r in (0 until half)) && (c in (0 until half))) 0
    else if ((r in (0 until half)) && (c in (half until n))) {
        c -= half; half * half
    } else if ((r in (half until n)) && (c in (0 until half))) {
        r -= half; half * half * 2
    } else {
        c -= half; r -= half; half * half * 3
    }
    val recursion = if (n > 2) getZRecursion(half) else 0
    return recursion + piece
}