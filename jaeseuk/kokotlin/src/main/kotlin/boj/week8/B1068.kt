package boj.week8

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

//  트리

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val tree = Array<MutableList<Int>>(n) { mutableListOf() }
    val deleted = BooleanArray(n)

    StringTokenizer(br.readLine()).run {
        repeat(n) {
            val parent = nextToken().toInt()

            if (parent != -1) tree[parent].add(it)
        }
    }

    val deleteKey = br.readLine().toInt()

    deleteNode(tree, deleted, deleteKey)

    var answer = 0

    for (i in 0 until n) {
        if (!deleted[i] && tree[i].count { !deleted[it] } == 0) answer++
    }

    bw.append("$answer")
    bw.flush()
    bw.close()
}

private fun deleteNode(tree: Array<MutableList<Int>>, deleted: BooleanArray, deleteKey: Int) {
    deleted[deleteKey] = true

    tree[deleteKey].forEach {
        deleteNode(tree, deleted, it)
    }
}