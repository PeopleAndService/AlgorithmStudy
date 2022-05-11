package baekjoon.string

// 광고

fun main() {
    val br = System.`in`.bufferedReader()
    val l = br.readLine().toInt()
    val ad = br.readLine()
    print(solution(l, ad))
}

private fun solution(parentLength: Int, parent: String): Int {
    val table = IntArray(parentLength)

    var idx = 0
    for (i in 1 until parentLength) {
        while (idx > 0 && parent[idx] != parent[i]) {
            idx = table[idx - 1]
        }

        if (parent[idx] == parent[i]) {
            idx += 1
            table[i] = idx
        }
    }

    return parentLength - idx
}