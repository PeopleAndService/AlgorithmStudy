package twopointer_prefixsum

import java.util.StringTokenizer

// 회전 초밥

fun main() {
    val br = System.`in`.bufferedReader()
    val n: Int; val d: Int; val k: Int; val c: Int
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt(); d = nextToken().toInt()
        k = nextToken().toInt(); c = nextToken().toInt()
    }
    val sushi = IntArray(n) {br.readLine().toInt()}
    val eat = IntArray(d+1)

    var cnt = 0; var answer = 0
    for (i in sushi.slice(0 until k)) if (eat[i]++ == 0) cnt++

    for (start in 1 until n) {
        answer = maxOf(answer, if (eat[c] > 0) cnt else cnt + 1)
        val end = (start + k - 1) % n

        if (eat[sushi[end]]++ == 0) cnt++
        if (--eat[sushi[start-1]] == 0) cnt --
    }

    print(answer)
}