package trie_hash

import java.util.StringTokenizer
import java.util.TreeMap

// 개미굴

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val root = Trie14275()

    repeat(n) {
        with(StringTokenizer(br.readLine())) {
            val k = nextToken().toInt()
            var node = root.node
            for (i in 0 until k) {
                node = node.map.getOrPut(nextToken()) { Node14725() }
            }
        }
    }

    root.node.print()

    bw.close()
}

private data class Trie14275(
    val node: Node14725 = Node14725(),
)

private data class Node14725(
    val map: TreeMap<String, Node14725> = TreeMap<String, Node14725>(),
) {
    fun print(depth: Int = 0) {
        for (string in map.keys) {
            bw.write("${"--".repeat(depth)}${string}\n")
            map[string]?.print(depth + 1)
        }
    }
}