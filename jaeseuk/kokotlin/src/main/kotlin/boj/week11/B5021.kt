package boj.week11

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

//  왕위 계승

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private var n = 0
private var m = 0

private val children = mutableMapOf<String, Pair<String, String>>()
private val nearest = mutableMapOf<String, Double>()

fun main() {
    with(StringTokenizer(br.readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }

    val king = br.readLine()

    repeat(n) {
        with(StringTokenizer(br.readLine())) {
            val child = nextToken()
            val p1 = nextToken()
            val p2 = nextToken()

            children[child] = p1 to p2
            nearest[child] = 0.0
            nearest[p1] = 0.0
            nearest[p2] = 0.0
        }
    }

    nearest[king] = 1.0

    var answer = ""

    repeat(m) {
        val person = br.readLine()

        answer = maxOf(answer, person, compareBy { dfs(it) })
    }

    bw.write(answer)
    bw.flush()
    bw.close()
}

private fun dfs(child: String): Double {
    return when {
        !nearest.containsKey(child) -> 0.0
        !children.containsKey(child) -> nearest[child]!!
        else -> {
            val p1 = children[child]!!.first
            val p2 = children[child]!!.second

            nearest[child] = (dfs(p1) + dfs(p2)) / 2
            nearest[child]!!
        }
    }
}