package baekjoon.trie_hash

import java.util.*

// 문자열 집합 판별

private val root = Trie9250()

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    repeat(n) {
        var node = root.node
        for (char in br.readLine()) {
            node = node.map.getOrPut(char) { Node9250() }
        }
        node.endOfString = true
    }

    root.node.computeFail()

    val q = br.readLine().toInt()
    repeat(q) {
        bw.write(if (root.node.search(br.readLine())) "YES\n" else "NO\n")
    }

    bw.close()
    br.close()
}

private data class Trie9250(
    val node: Node9250 = Node9250(),
)

private data class Node9250(
    val map: TreeMap<Char, Node9250> = TreeMap<Char, Node9250>(),
    var endOfString: Boolean = false,
) {
    lateinit var fail: Node9250

    fun computeFail() {
        val queue = LinkedList<Node9250>()
        this.fail = this
        queue.add(this)

        while (queue.isNotEmpty()) {
            val current = queue.poll()
            for ((char, next) in current.map) {

                next.fail = if (current == this) {
                    this
                } else {
                    var failNode: Node9250 = current.fail
                    while (failNode != this && failNode.map[char] == null) {
                        failNode = failNode.fail
                    }
                    if (failNode.map[char] != null) failNode = failNode.map[char]!!
                    failNode
                }

                if (next.fail.endOfString) next.endOfString = true

                queue.add(next)
            }
        }

    }

    fun search(word: String): Boolean {
        var current = this
        for (char in word) {
            while (current != this && current.map[char] == null) {
                current = current.fail
            }

            current = current.map[char] ?: current

            if (current.endOfString) return true
        }
        return false
    }
}