package boj.week11

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

//  친구 네트워크

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    repeat(br.readLine().toInt()) {
        val f = br.readLine().toInt()

        val parents = mutableMapOf<String, String>()
        val networkCnt = mutableMapOf<String, Int>()

        for (i in 0 until f) {
            StringTokenizer(br.readLine()).run {
                val a = nextToken()
                val b = nextToken()

                if (!parents.containsKey(a)) {
                    parents[a] = a
                    networkCnt[a] = 1
                }

                if (!parents.containsKey(b)) {
                    parents[b] = b
                    networkCnt[b] = 1
                }

                bw.write("${union(parents, networkCnt, a, b)}")
                bw.newLine()
            }
        }
    }

    bw.flush()
    bw.close()
}

private fun find(parents: MutableMap<String, String>, x: String): String {
    if (parents[x] != x) parents[x] = find(parents, parents[x]!!)
    return parents[x]!!
}

private fun union(parents: MutableMap<String, String>, networkCnt: MutableMap<String, Int>, a: String, b: String): Int {
    val ap = find(parents, a)
    val bp = find(parents, b)

    if (ap != bp) {
        parents[bp] = ap
        networkCnt[ap] = networkCnt[ap]!! + networkCnt[bp]!!
    }

    return networkCnt[ap]!!
}