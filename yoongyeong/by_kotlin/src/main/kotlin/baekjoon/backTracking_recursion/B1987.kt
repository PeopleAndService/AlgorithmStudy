package baekjoon.backTracking_recursion

import java.util.StringTokenizer

// 알파벳

private var r = 0
private var c = 0
private lateinit var alphabet: Array<CharArray>
private val stepR = arrayOf(1, -1, 0, 0)
private val stepC = arrayOf(0, 0, 1, -1)

private val visited = BooleanArray(26)
private var maximum = Int.MIN_VALUE

fun main() {
    val br = System.`in`.bufferedReader()
    with(StringTokenizer(br.readLine())) {
        r = nextToken().toInt()
        c = nextToken().toInt()
    }

    alphabet = Array(r) { br.readLine().toCharArray() }

    visited[alphabet[0][0] - 'A'] = true
    dfs()
    print(maximum)

}

private fun dfs(i: Int = 0, j: Int = 0, cnt: Int = 1) {
    maximum = maxOf(maximum, cnt)

    for (step in 0 until 4) {
        val nextR = stepR[step] + i
        val nextC = stepC[step] + j
        if (nextR in 0 until r && nextC in 0 until c ) {
            val charIdx = alphabet[nextR][nextC]-'A'
            if (!visited[charIdx]) {
                visited[charIdx] = true
                dfs(nextR, nextC, cnt+1)
                visited[charIdx] = false
            }
        }
    }

}