package baekjoon.trie_hash

import java.util.StringTokenizer

// 무한 수열

private val map = HashMap<Long, Long>()
private var n = 0L
private var p = 0L
private var q = 0L

fun main() {
    val br = System.`in`.bufferedReader()
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toLong()
        p = nextToken().toLong()
        q = nextToken().toLong()
    }
    print(dp(n))
}

private fun dp(num: Long): Long {
    return if (num == 0L) 1
    else map.getOrPut(num) { dp(num / p) + dp(num / q) }
}