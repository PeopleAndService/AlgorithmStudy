package baekjoon.string

// 찾기

fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine()
    val p = br.readLine()

    val answer = kmp(t, p)

    println(answer.size)
    println(answer.joinToString(" "))
}

private fun makeTable(pattern: String): IntArray {
    val patternLength = pattern.length
    val table = IntArray(patternLength)

    var idx = 0
    for (i in 1 until patternLength) {
        while (idx > 0 && pattern[idx] != pattern[i]) {
            idx = table[idx - 1]
        }

        if (pattern[idx] == pattern[i]) {
            idx += 1
            table[i] = idx
        }
    }

    return table
}

private fun kmp(parent: String, pattern: String): MutableList<Int> {
    val answer = mutableListOf<Int>()

    val parentLength = parent.length
    val patternLength = pattern.length

    val table = makeTable(pattern)

    var idx = 0
    for (i in 0 until parentLength) {
        while (idx > 0 && parent[i] != pattern[idx]) {
            idx = table[idx - 1]
        }

        if (pattern[idx] == parent[i]) {
            if (idx == patternLength - 1) {
                answer.add(i - idx + 1)
                idx = table[idx]
            } else {
                idx += 1
            }
        }
    }

    return answer
}