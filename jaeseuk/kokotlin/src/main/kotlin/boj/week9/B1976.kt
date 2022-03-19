package boj.week9

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

//  여행 가자

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    val parents = IntArray(n + 1) { it }

    repeat(n) { i ->
        StringTokenizer(br.readLine()).run {
            repeat(n) { j ->
                val connect = nextToken().toInt()
                if (connect == 1) union(parents, i + 1, j + 1)
            }
        }
    }

    val plan = StringTokenizer(br.readLine()).run { IntArray(m) { nextToken().toInt() } }
    val parent = parents[plan[0]]

    var answer = "YES"

    for (i in 1 until m) {
        if (parents[plan[i]] != parent) {
            answer = "NO"
            break
        }
    }

    bw.append(answer)
    bw.flush()
    bw.close()
}

private fun findParent(parents: IntArray, x: Int): Int {
    if (parents[x] != x) parents[x] = findParent(parents, parents[x])
    return parents[x]
}

private fun union(parents: IntArray, a: Int, b: Int) {
    val ap = findParent(parents, a)
    val bp = findParent(parents, b)

    if (ap > bp) parents[ap] = bp
    else parents[bp] = ap
}