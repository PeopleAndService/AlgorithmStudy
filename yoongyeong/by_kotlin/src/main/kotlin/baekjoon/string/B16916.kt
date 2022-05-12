package baekjoon.string

// 부분 문자열

fun main() {
    val br = System.`in`.bufferedReader()
    val s = br.readLine()
    val p = br.readLine()

    println(if (kmp(s, p)) 1 else 0)
}

private fun makeTable(pattern: String): IntArray {
    val patternSize = pattern.length
    val table = IntArray(patternSize)
    var idx = 0
    for (i in 1 until patternSize) {
        while (idx > 0 && pattern[i] != pattern[idx]) {
            idx = table[idx - 1]
        }

        if (pattern[i] == pattern[idx]) {
            idx += 1
            table[i] = idx
        }
    }

    return table
}

private fun kmp(parent: String, pattern: String): Boolean {
    val table = makeTable(pattern)

    val n1 = parent.length
    val n2 = pattern.length

    var idx = 0
    for (i in 0 until n1) {
        while (idx > 0 && parent[i] != pattern[idx]) {
            idx = table[idx - 1]
        }

        if (parent[i] == pattern[idx]) {
            if (idx == n2 - 1) {
                return true
            } else {
                idx += 1
            }
        }
    }

    return false
}

/*
* O(n^2) 풀이 - DP LCS -> 메모리 초과, 시간 초과
* O(n+m) 풀이 - KMP 알고리즘
*/